package com.leader.demo.study.jdk8.stream;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author: changhao
 * @time: 2019-09-04
 */
public class Streams {
    private enum Status {
        OPEN, CLOSED
    };

    private static final class Task {
        private final Status status;
        private final Integer points;

        Task( final Status status, final Integer points ) {
            this.status = status;
            this.points = points;
        }

        public Integer getPoints() {
            return points;
        }

        public Status getStatus() {
            return status;
        }

        @Override
        public String toString() {
            return String.format( "[%s, %d]", status, points );
        }
    }

    public static void main(String[] args) {
        Collection< Task > tasks = Arrays.asList(
                new Task( Status.OPEN, 5 ),
                new Task( Status.OPEN, 13 ),
                new Task( Status.CLOSED, 8 )
        );

        int sum = tasks.stream()
                .filter(task -> task.getStatus() == Status.OPEN).mapToInt(Task::getPoints).sum();
        System.out.println(sum);

        double totalPoints = tasks.stream().parallel()
                .map(task -> task.getPoints())
                .reduce(0,Integer::sum);
        System.out.println("Total points (all tasks)"+totalPoints);

        Map<Status, List<Task>> map = tasks.stream().collect(Collectors.groupingBy(Task::getStatus));
        System.out.println(map);

        Collection<String> result = tasks
                .stream()
                .mapToInt(Task::getPoints)
                .asLongStream()
                .mapToDouble(points->points/totalPoints)
                .boxed()
                .mapToLong(weight->(long)(weight*100))
                .mapToObj(percentage->percentage+"%")
                .collect(Collectors.toList());
        System.out.println(result);

       // /Users/oyo/logs/ons1.log
            Path path = new File( "/Users/oyo/Desktop/OPENAPI飞猪会员配置单.docx" ).toPath();
            try( Stream< String > lines = Files.lines( path, StandardCharsets.UTF_8 ) ) {
                lines.onClose( () -> System.out.println("Done!") ).forEach( System.out::println );
            }catch (IOException e) {
                e.printStackTrace();
            }

    }
}
