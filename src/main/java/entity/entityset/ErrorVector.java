package entity.entityset;

import java.util.Vector;

public class ErrorVector {
	private static boolean failedCheck = false;	
	public static boolean isFailedCheck() {
		return failedCheck;
	}
	public static void setFailedCheck(boolean failedCheck) {
		ErrorVector.failedCheck = failedCheck;
	}
	

	Vector<String> ErerorSetVector = new Vector<String>();
	Vector<String> Ereror4OneErrorTempVector = new Vector<String>();
	Vector<String> Ereror4OneOtherErrorTempVector = new Vector<String>();
	
	
	public Vector<String> getEreror4OneOtherErrorTempVector() {
		return Ereror4OneOtherErrorTempVector;
	}

	public void setEreror4OneOtherErrorTempVectorByKey(String Key) {
		Ereror4OneOtherErrorTempVector.add(Key);
	}
	
	public boolean RemoveEreror4OneOtherErrorTempVectorByKey (String Key){
		return Ereror4OneOtherErrorTempVector.remove(Key);
	}
	
	
	public Vector<String> getEreror4OneErrorTempVector() {
		return Ereror4OneErrorTempVector;
	}

	public void setEreror4OneErrorTempVectorByKey(String Key) {
		Ereror4OneErrorTempVector.add(Key);
	}
	
	public boolean RemoveEreror4OneErrorTempVectorByKey (String Key){
		return Ereror4OneErrorTempVector.remove(Key);
	}
	
	
	public Vector<String> getErerorSetVectorVector() {
		return ErerorSetVector;
	}

	public void setErerorSetVectorByKey(String Key) {
		ErerorSetVector.add(Key);
	}
	
	public boolean RemoveErerorSetVectorByKey (String Key){
		return ErerorSetVector.remove(Key);
	}
}
