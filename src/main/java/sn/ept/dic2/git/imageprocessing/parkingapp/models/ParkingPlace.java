package sn.ept.dic2.git.imageprocessing.parkingapp.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamicInsert
public class ParkingPlace implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String clientFullName;
    @Column(unique = true)
    private String matriculeCar;
    private String phoneNumber;
    @Column(unique = true)
    private String parkingNumber;
    @Column(columnDefinition = "varchar(255) default 'Pending'")
    private String status;


}
