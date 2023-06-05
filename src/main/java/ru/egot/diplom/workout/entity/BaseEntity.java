package ru.egot.diplom.workout.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    protected Long id;

    @CreatedDate
    @Column(name = "CREATED_DATE")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    protected LocalDateTime createdDate;

    @LastModifiedDate
    @Column(name = "UPDATED_DATE")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    protected LocalDateTime updatedDate;

    @Column(name = "DELETED_DATE")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    protected LocalDateTime deletedDate;

}
