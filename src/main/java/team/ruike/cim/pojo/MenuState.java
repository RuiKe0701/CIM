package team.ruike.cim.pojo;


import java.io.Serializable;

/**
 * 菜谱状态
 *
 * @author 甄立
 * @version 1.0
 */
public class MenuState implements Serializable {

    private static final long serialVersionUID = 3179068846309159854L;
    /**
     * 菜谱状态 id
     */
    private Integer menuStateId;
    /**
     * 状态名称
     */
    private Integer menuStateName;
    /**
     * 删除状态
     */
    private Integer status;


    public Integer getMenuStateId() {
        return menuStateId;
    }

    public void setMenuStateId(Integer menuStateId) {
        this.menuStateId = menuStateId;
    }


    public Integer getMenuStateName() {
        return menuStateName;
    }

    public void setMenuStateName(Integer menuStateName) {
        this.menuStateName = menuStateName;
    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}
