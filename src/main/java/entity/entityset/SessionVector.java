package entity.entityset;

import java.util.Vector;

public class SessionVector {
//	private SetSession session = new SetSession();
	Vector<String> SessionVector = new Vector<String>();
	Vector<String> SessionFinishedCheckErrorVector = new Vector<String>();
	Vector<String> SessionFinishedVector = new Vector<String>();
	Vector<String> SessionCreateTempVector = new Vector<String>();
	Vector<String> SessionJobCreateTempVector = new Vector<String>();
	Vector<String> SessionrunningTimeVector = new Vector<String>();
	Vector<String> SessionrunVector = new Vector<String>();
//	public SessionVector(){
//		SessionVector.add(" ");
//		SessionFinishedVector.add(" ");
//		SessionCreateTempVector.add(" :this is separator: :this is separator: :this is separator: ");
//		SessionJobCreateTempVector.add("  :this is separator:  :this is separator:  :this is separator:  ");
//	}
	
	
	public String getSessionrunVectorByKey(String Key) {
		for (String str:SessionrunVector){
			if (Key.equals(str)){
				return str;
			}
		}
		return "";
	}

	public  Vector<String> getSessionrunVector() {
		return SessionrunVector;
	}

	public void setSessionrunVectorByKey(String Session) {
		SessionrunVector.add(Session);
	}
	
	public boolean RemoveSessionrunVectorByKey (String session){
		return SessionrunVector.remove(session);
	}
	
	
	
	
	public String getSessionrunningTimeVectorByKey(String Key) {
		for (String str:SessionrunningTimeVector){
			if (Key.equals(str)){
				return str;
			}
		}
		return "";
	}

	public  Vector<String> getSessionrunningTimeVector() {
		return SessionrunningTimeVector;
	}

	public void setSessionrunningTimeVectorByKey(String Session) {
		SessionrunningTimeVector.add(Session);
	}
	
	public boolean RemoveSessionrunningTimeVectorByKey (String session){
		return SessionrunningTimeVector.remove(session);
	}
	
	
	
	
	
	
	
	public String getSessionJobCreateTempVectorByKey(String Key) {
		for (String str:SessionJobCreateTempVector){
			if (Key.equals(str)){
				return str;
			}
		}
		return "";
	}

	public  Vector<String> getSessionJobCreateTempVector() {
		return SessionJobCreateTempVector;
	}

	public void setSessionJobCreateTempVectorByKey(String Session) {
		SessionJobCreateTempVector.add(Session);
	}
	
	public boolean RemoveSessionJobCreateTempVectorByKey (String session){
		return SessionJobCreateTempVector.remove(session);
	}
	
	
	public String getSessionCreateTempVectorByKey(String Key) {
		for (String session:SessionCreateTempVector){
			if (Key.equals(session)){
				return session;
			}
		}
		return "";
	}

	public  Vector<String> getSessionCreateTempVector() {
		return SessionCreateTempVector;
	}

	public void setSessionCreateTempVectorByKey(String Session) {
		SessionCreateTempVector.add(Session);
	}
	
	public boolean RemoveSessionCreateTempVectorByKey (String Key){
		return SessionCreateTempVector.remove(Key);
	}
	

	
	
	
	public Vector<String> getSessionFinishedCheckErrorVector() {
		return SessionFinishedCheckErrorVector;
	}

	public void setSessionFinishedCheckErrorVectorByKey(String Session) {
		SessionFinishedCheckErrorVector.add(Session);
	}
	
	public void RemoveSessionFinishedCheckErrorVector (){
		SessionFinishedCheckErrorVector.removeAllElements();
	}
	
	
	
	
	
	
	
	
	public Vector<String> getSessionFinishedVector() {
		return SessionFinishedVector;
	}
//!
	public void setSessionFinishedVectorByKey(String Session) {
		SessionFinishedVector.add(Session);
	}
	
	public void RemoveSessionFinishedVector (){
		SessionFinishedVector.removeAllElements();
	}
//	public String getSessionVectorByKey(String Key) {
//		for (String session:SessionFinishedVector){
//			if (Key.equals(session)){
//				return session;
//			}
//		}
//		return "";
//	}

	public  Vector<String> getSessionVector() {
		return SessionVector;
	}

	public void setSessionVectorByKey(String Session) {
		SessionVector.add(Session);
	}
	
	public boolean RemoveSessionVectorByKey (String Key){
		return SessionVector.remove(Key);
	}
	
//	public static void main(String[] args) {
//		SessionVector v = new SessionVector();
//		v.setSessionVectorByKey("a");
//		v.setSessionVectorByKey("b");
//		v.setSessionVectorByKey("c");
//		
//		Vector<String> x = v.getSessionVector();
//		
//		for (String a:x){
//			System.out.println(a);
//		}
//		System.out.println();
//		
//		System.out.println(v.RemoveSessionVectorByKey("a"));
//		
//		for (String a:x){
//			System.out.println(a);
//		}
//		System.out.println();
//		
//		System.out.println(v.RemoveSessionVectorByKey("b"));
//		System.out.println(v.RemoveSessionVectorByKey("c"));
//		for (String a:x){
//			System.out.println(a);
//		}
//	}
}
