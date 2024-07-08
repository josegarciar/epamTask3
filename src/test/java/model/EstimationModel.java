package model;

public class EstimationModel {
    private String searchData;
    private String instanceNumber;
    private String operatingSystem;
    private String provisioningModel;
    private String machineType;
    private boolean addGpus;
    private String gpuModel;
    private String numberOfGpus;
    private String localSsd;
    private String region;
    private String commitedUseDiscount;

    // Getters and Setters
    public String getSearchData() {
        return searchData;
    }

    public void setSearchData(String searchData) {
        this.searchData = searchData;
    }

    public String getInstanceNumber() {
        return instanceNumber;
    }

    public void setInstanceNumber(String instanceNumber) {
        this.instanceNumber = instanceNumber;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getProvisioningModel() {
        return provisioningModel;
    }

    public void setProvisioningModel(String provisioningModel) {
        this.provisioningModel = provisioningModel;
    }

    public String getMachineType() {
        return machineType;
    }

    public void setMachineType(String machineType) {
        this.machineType = machineType;
    }

    public boolean isAddGpus() {
        return addGpus;
    }

    public void setAddGpus(boolean addGpus) {
        this.addGpus = addGpus;
    }

    public String getGpuModel() {
        return gpuModel;
    }

    public void setGpuModel(String gpuModel) {
        this.gpuModel = gpuModel;
    }

    public String getNumberOfGpus() {
        return numberOfGpus;
    }

    public void setNumberOfGpus(String numberOfGpus) {
        this.numberOfGpus = numberOfGpus;
    }

    public String getLocalSsd() {
        return localSsd;
    }

    public void setLocalSsd(String localSsd) {
        this.localSsd = localSsd;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCommitedUseDiscount() {
        return commitedUseDiscount;
    }

    public void setCommitedUseDiscount(String commitedUseDiscount) {
        this.commitedUseDiscount = commitedUseDiscount;
    }
}
