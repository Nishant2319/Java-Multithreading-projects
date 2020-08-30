package MMN15Q2;

class Main {


    public static void main(String[] args) {


        Airport israelAirport = new Airport("Israel", 3);
        Airport usaAirport = new Airport("USA", 3);

        Flight[] flights = new Flight[2];

        for (int i = 0; i < flights.length; i++) {//switching before 4 options for flights
            int random = (int) (Math.random() * 4);

            switch (random) {

                case 0: {
                    flights[i] = new Flight(i, israelAirport, usaAirport);
                    break;
                }
                case 1: {
                    flights[i] = new Flight(i, usaAirport, israelAirport);
                    break;

                }
                case 2: {
                    flights[i] = new Flight(i, israelAirport, israelAirport);
                    break;

                }
                case 3: {
                    flights[i] = new Flight(i, usaAirport, usaAirport);
                    break;
                }

            }

        }

        for (Flight flight : flights) {
            flight.start();
        }


    }


}
