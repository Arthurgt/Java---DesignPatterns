package adapter;

public class TwoWayUKContinentalAdapter implements ContinentalDevice, UKDevice {
    private UKDevice ukDevice;
    private ContinentalDevice continentalDevice;

    public TwoWayUKContinentalAdapter(UKDevice ukDevice, ContinentalDevice continentalDevice) {
        this.ukDevice = ukDevice;
        this.continentalDevice = continentalDevice;
    }

    @Override
    public void play() {
        continentalDevice.powerOn();
    }

    @Override
    public void powerOn() {
        ukDevice.play();
    }
}
