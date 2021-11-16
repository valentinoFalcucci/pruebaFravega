package helpers;

public   class Helpers {
	
	public static void esperar(int segundos)
	{
		try {
			Thread.sleep(segundos*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
