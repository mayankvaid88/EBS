package org.ebs.entity;

import org.ebs.convertors.UserRoleConvertor;
import org.ebs.enums.RoleE;

import javax.persistence.*;

@Table(name = "user_profile")
@Entity
@NamedQueries({
        @NamedQuery(name = "UserProfile.findByLoginId", query = "select c from UserProfileEntity c where c.loginId = :loginId")
})
public class UserProfileEntity {

    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "login_id")
    private String loginId;
    @Column(name = "name")
    private String name;
    @Column(name = "role")
    @Convert(converter = UserRoleConvertor.class)
    private RoleE roleE;

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RoleE getRoleE() {
        return roleE;
    }

    public void setRoleE(RoleE roleE) {
        this.roleE = roleE;
    }
}
