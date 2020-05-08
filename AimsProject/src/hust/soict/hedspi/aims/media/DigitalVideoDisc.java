package hust.soict.hedspi.aims.media;


public class DigitalVideoDisc extends Disc implements Playable{
		
    public DigitalVideoDisc(String title) {
        this.title = title;
    }

	
	public DigitalVideoDisc(String title, String category) {
        this.title = title;
        this.category = category;
    }

    public DigitalVideoDisc(String title, String category, String director) {
        this.title = title;
        this.category = category;
        this.director = director;
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
    }


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getDirector() {
		return director;
	}


	public void setDirector(String director) {
		this.director = director;
	}


	public int getLength() {
		return length;
	}


	public void setLength(int length) {
		this.length = length;
	}


	public float getCost() {
		return cost;
	}


	public void setCost(float cost) {
		this.cost = cost;
	}
	
	public boolean search(String title) {
		boolean check = false;
		if(this.title.equalsIgnoreCase(title))
			return true;
		String [] arr = title.split(" ");
//		for(int i=0;i<arr.length;i++) {
//			System.out.println(arr[i]);
//		}
		String [] temp_title = this.title.split(" ");
		System.out.println(this.title);
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<temp_title.length;j++) {
				if(arr[i].equalsIgnoreCase(temp_title[j]))
					check = true;
					break;
			}
			if(!check)
				return false;
		}
		
		return true;
	}


	@Override
	public void print() {
		// TODO Auto-generated method stub
		super.print();
		if(this.getCost() == 0) {
			System.out.printf("%d. %s - %s - %s - %d: %f$ (Lucky item)\n",this.getId(),this.getTitle(),this.getCategory(),this.getDirector(),this.getLength(),this.getCost());
		}else
			System.out.printf("%d. %s - %s - %s - %d: %f$ \n",this.getId(),this.getTitle(),this.getCategory(),this.getDirector(),this.getLength(),this.getCost());
	}


	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}

	
}
