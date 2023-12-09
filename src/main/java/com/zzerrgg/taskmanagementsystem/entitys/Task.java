package com.zzerrgg.taskmanagementsystem.entitys;

import com.zzerrgg.taskmanagementsystem.enums.Priority;
import com.zzerrgg.taskmanagementsystem.enums.Status;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tasks")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Task {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "task_id")
        Long id;

        @Column(nullable = false)
        String title;

        @Column(nullable = false)
        String description;

        @Column(name = "time_when_created", nullable = false)
        LocalDateTime timeWhenCreated;

        Duration duration;

        @Column(name = "time_when_finished")
        LocalDateTime timeWhenFinished;

        @Column(nullable = false)
        @Enumerated(EnumType.STRING)
        Status status;

        @Column(nullable = false)
        @Enumerated(EnumType.STRING)
        Priority priority;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "author_id", referencedColumnName = "user_id")
        @OnDelete(action = OnDeleteAction.CASCADE)
        User author;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "executor_id", referencedColumnName = "user_id")
        @OnDelete(action = OnDeleteAction.CASCADE)
        User executor;

        @OneToMany(mappedBy = "task")
        List<Comment> comments;

}
