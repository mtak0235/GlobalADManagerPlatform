package seoul.globalAdManagerPlatformByMtak.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AD {
    private String title;
    private String content;
    private String url;
    private Target target;
    private int allocationBudgetPerDay;
}
