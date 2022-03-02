package com.yee.spring.ws.config;

import com.yee.spring.ws.file.FileChangeEvent;
import com.yee.spring.ws.file.FileChangeListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

@Component
public class DirectoryTargetMonitor implements InitializingBean, ApplicationRunner, DisposableBean {

    private static final Logger LOGGER = LoggerFactory.getLogger(DirectoryTargetMonitor.class);

    @Value("${monitor.log-path:./data.log}")
    private String logPath;

    private WatchService watchService;

    private Path path;

    @Autowired
    private FileChangeListener listener;

    private volatile boolean start = false;

    @Override
    public void afterPropertiesSet() throws Exception {
        this.watchService = FileSystems.getDefault().newWatchService();
        this.path = Paths.get(logPath);
        // 注册变更事件到WatchService
        this.path.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY);
        this.start = true;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        while (start) {
            WatchKey watchKey = null;
            try {
                // 阻塞直到有事件发生
                watchKey = watchService.take();
                watchKey.pollEvents().forEach(event -> {
                    WatchEvent.Kind<?> kind = event.kind();
                    Path path = (Path) event.context();
                    Path child = this.path.resolve(path);
                    listener.fire(new FileChangeEvent(child, kind));
                });
            } catch (Exception e) {
                this.start = false;
            } finally {
                if (watchKey != null) {
                    watchKey.reset();
                }
            }
        }
    }

    @Override
    public void destroy() throws Exception {
        System.out.printf("The directory [%s] monitor will be stop ...\n", path);
        this.start = false;
        this.watchService.close();
        System.out.printf("The directory [%s] monitor will be stop done.\n", path);
    }

}
