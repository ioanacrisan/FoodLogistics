package si.um.opj.crisan.logic;

public class Location {
   private String city;
   private String country;
    /**
     * Default constructor of si.um.opj.crisan.logic.Location class
     */
   public Location(){

   }
    /**
     * Parametrized constructor of si.um.opj.crisan.logic.Location class
     * @param city city of si.um.opj.crisan.logic.Location
     * @param country country of si.um.opj.crisan.logic.Location
     */
   public Location(String city , String country)
    {
        this.city=city;
        this.country=country;
    }

    /**
     * si.um.opj.crisan.logic.Location's label getter
     * @return city of si.um.opj.crisan.logic.Location
     */
    public String getCity()
    {
        return city;
    }
    /**
     * si.um.opj.crisan.logic.Location's label getter
     * @return country of si.um.opj.crisan.logic.Location
     */
    public String getCountry()
    {
        return country;
    }

    /**
     *si.um.opj.crisan.logic.Location's city setter
     * @param city label of si.um.opj.crisan.logic.Location
     */

    public void setCity(String city)
    {
        this.city=city;

    }
    /**
     *si.um.opj.crisan.logic.Location's city setter
     * @param country label of si.um.opj.crisan.logic.Location
     */
    public void setCountry(String country)
    {
        this.country=country;

    }

    @Override
    public String toString() {
        return "Location{" +
                "city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
