package pl.wsb.helpdesk.ticket.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class DeviceDetails {

    @Column(name="asset_tag", length = 50)
    private String assetTag;

    @Column(name = "operating_system", length = 50)
    private String operatingSystem; // np. Windows 11, Fedora

    protected DeviceDetails() {
    }

    public DeviceDetails(String assetTag, String operatingSystem) {
        this.assetTag = assetTag;
        this.operatingSystem = operatingSystem;
    }

    public String getAssetTag() {
        return assetTag;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }
}
