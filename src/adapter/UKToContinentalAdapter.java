package adapter;

public class UKToContinentalAdapter implements ContinentalDevice {
    private UKDevice ukDevice;

    public UKToContinentalAdapter(UKDevice ukDevice) {
        this.ukDevice = ukDevice;
    }

    @Override
    public void powerOn() {
        ukDevice.play();
    }
}
