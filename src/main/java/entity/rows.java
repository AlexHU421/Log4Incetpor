package entity;

public class rows {
	private int newnewfilesize;
	private int oldnewfilesize;
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
	@Override
	public String toString() {
		return "rows [newnewfilesize=" + newnewfilesize + ", oldnewfilesize=" + oldnewfilesize + ", checkNewFile="
				+ checkNewFile + "]";
	}
	
}
