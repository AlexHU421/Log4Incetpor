package entity;

public class rows {
	private int newnewfilesize;
	private int oldnewfilesize;
	private long oldStartTime;
	private String temp;
	
	public String getTemp() {
		return temp;
	}
	public void setTemp(String temp) {
		this.temp = temp;
	}
	public long getOldStartTime() {
		return oldStartTime;
	}
	public void setOldStartTime(long oldStartTime) {
		this.oldStartTime = oldStartTime;
	}
	private boolean checkNewFile =  false;
	
	public boolean isCheckNewFile() {
		return checkNewFile;
	}
	public void setCheckNewFile(boolean checkNewFile) {
		this.checkNewFile = checkNewFile;
	}
	public int getNewnewfilesize() {
		return newnewfilesize;
	}
	public void setNewnewfilesize(int newnewfilesize) {
		this.newnewfilesize = newnewfilesize;
	}
	public int getOldnewfilesize() {
		return oldnewfilesize;
	}
	public void setOldnewfilesize(int oldnewfilesize) {
		this.oldnewfilesize = oldnewfilesize;
	}
	
}
