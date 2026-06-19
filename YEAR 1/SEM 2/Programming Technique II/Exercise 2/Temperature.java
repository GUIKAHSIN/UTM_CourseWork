package Exercise_week2;

public class Temperature {
    private double calcius; 
    private double fahrenheit;

    public Temperature()
    {
        calcius = 0.0;
        fahrenheit = 0.0;
    }

    public Temperature(double calcius)
    {
        this.calcius = calcius;
    }

    public void setCelcius(double calcius)
    {
        this.calcius = calcius;
    }

    public void setFahrenheit(double fahrenheit)
    {
        this.fahrenheit = fahrenheit;
    }

    public double getCalcius()
    {
        return calcius;
    }

    public double getFahrenheit()
    {
        return fahrenheit;
    }

    public double convert()
    {
        return (calcius * 9/5) + 32;
    }
    
}
