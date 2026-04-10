class ParkingSystem {
    private int carParking[] = new int[3];

    public ParkingSystem(int big, int medium, int small) {
        carParking = new int[] { big, medium, small };
    }

    public boolean addCar(int carType) {
        if (carParking[carType - 1] > 0) {
            carParking[carType - 1]--;
            return true;
        }

        return false;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */