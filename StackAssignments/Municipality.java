public class Municipality
{
	private String name, county, type;

	public Municipality(String name, String county, String type)
	{
		this.name = name;
		this.county = county;
		this.type = type;
	}

	public String getName()
	{
		return name;
	}

	public String getCounty()
	{
		return county;
	}

	public String getType()
	{
		return type;
	}
}