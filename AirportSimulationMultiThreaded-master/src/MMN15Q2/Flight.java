package MMN15Q2;

class Flight extends Thread {

    private final int flightNumber;
    private final Airport departAirportName;
    private final Airport landAirportName;

    public Flight(int flightNumber, Airport departAirportName, Airport landAirportName) {//making a flight
        this.flightNumber = flightNumber;
        this.departAirportName = departAirportName;
        this.landAirportName = landAirportName;
    }


    public void run() {// the whole procces

        int departFreeLane = departAirportName.depart(flightNumber);
        departing();
        departAirportName.freeRunway(flightNumber, departFreeLane);
        flying();
        int landFreeLane = landAirportName.land(flightNumber);
        landing();
        landAirportName.freeRunway(flightNumber, landFreeLane);
    }

    private void departing() {
        int departTime = (int) (Math.random() * 5000);
        try {
            Thread.sleep(departTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    private void flying() {
        int flyingTime = (int) (Math.random() * 20000);
        System.out.println("Flight " + flightNumber + " IN THE AIR! ");

        try {
            Thread.sleep(flyingTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


    private void landing() {
        int departTime = (int) (Math.random() * 5000);
        try {
            Thread.sleep(departTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
