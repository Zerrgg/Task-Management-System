package com.zzerrgg.taskmanagementsystem.entitys;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "comments")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    Long id;

    @Column(name = "content", nullable = false)
    String content;

    @Column(name = "time_when_created", nullable = false)
    LocalDateTime timeWhenCreated;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id", referencedColumnName = "user_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    User author;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_id", referencedColumnName = "task_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    Task task;
}
