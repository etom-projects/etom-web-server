package com.kurly.delivery.domain.address.model;

import com.kurly.delivery.domain.common.enumerable.Status;
import com.kurly.delivery.domain.common.model.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ADDRESS_GROUPS")
public class AddressGroup extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Address> addresses;

    @Enumerated(value = EnumType.STRING)
    private Status status;
}
