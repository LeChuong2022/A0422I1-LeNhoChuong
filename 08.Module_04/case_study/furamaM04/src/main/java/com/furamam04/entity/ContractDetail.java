package com.furamam04.entity;


import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@Entity
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_detail_id")
    private Long id;

    @Pattern(regexp = "(CD)[-][\\d]{4}", message = "{contractDetailId}")
    @Column(name = "contract_detail_string_id")
    private String stringId;

    @Min(value = 0L, message = "{integer}")
    @Column(nullable = false)
    private Integer quantity;

    @ManyToOne
//            (cascade = CascadeType.ALL) //- thêm cái này thì xóa luôn bên bảng quan hệ kia
    @JoinColumn(name = "attach_service_id", referencedColumnName = "attach_service_id", nullable = false)
    private AttachService attachService;

    @ManyToOne
    @JoinColumn(name = "contract_id", referencedColumnName = "contract_id", nullable = false)
    private Contract contract;

    public ContractDetail() {
    }

    public ContractDetail(Integer quantity) {
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getStringId() {
        return stringId;
    }

    public void setStringId(String stringId) {
        this.stringId = stringId;
    }

    public AttachService getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachService attachService) {
        this.attachService = attachService;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }
}
