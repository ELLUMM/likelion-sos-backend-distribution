package com.example.campus_sos.domain.sosrequest;

import com.example.campus_sos.domain.member.Member;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
public class SosRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ✅ 명시적으로 수정
    private Long id;

    @Enumerated(EnumType.STRING)
    private BuildingType building;

    private String title;

    @Lob
    private String content;

    private String openChatUrl;

    @Enumerated(EnumType.STRING)
    private SosStatus status = SosStatus.IN_PROGRESS;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member requester;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "helper_id")
    private Member helper;
}
