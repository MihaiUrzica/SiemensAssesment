package com.urzica_mihai.siemens_assesment.dao.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "feedbacks")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FeedbackEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "feedback")
    private String feedback;

}
