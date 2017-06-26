package castle;


import java.util.Scanner;

public class Game {
    private Room currentRoom;
   
    public Game() 
    {
        createRooms();
    }

    private void createRooms()
    {
        Room outside, lobby, pub, study, bedroom;

        //  ���췿��
        outside = new Room("�Ǳ���");
        lobby = new Room("����");
        pub = new Room("С�ư�");
        study = new Room("�鷿");
        bedroom = new Room("����");

        //  ��ʼ������ĳ���(ps:���Է���ļ����ɾ���κη���)
        outside.setExits("east", lobby);
        outside.setExits("south", study);
        outside.setExits("west", pub);
        lobby.setExits("west", outside);
        pub.setExits("east", outside);
        study.setExits("north", outside);
        study.setExits("east", bedroom);
        bedroom.setExits("west", study);
        lobby.setExits("up", pub);
        pub.setExits("down", lobby);

        currentRoom = outside;  //  �ӳǱ����⿪ʼ
    }

    private void printWelcome() {
        System.out.println();
        System.out.println("��ӭ�����Ǳ���");
        System.out.println("����һ���������ĵ���Ϸ��");
        System.out.println("�����Ҫ������������ 'help' ��");
        System.out.println();
        System.out.println("��������" + currentRoom);
        showPrint();
    }
    private void showPrint(){
    	 
         System.out.print("������: ");
         System.out.println(currentRoom.getExitDes());
         System.out.println();
    }
    // ����Ϊ�û�����

    private void printHelp() 
    {
        System.out.print("��·������������������У�go bye help");
        System.out.println("�磺\tgo east");
    }

    private void goRoom(String direction) 
    {
        Room nextRoom = currentRoom.goExit(direction);
       
        if (nextRoom == null) {
            System.out.println("����û���ţ�");
        }
        else {
            currentRoom = nextRoom;
            System.out.println("����" + currentRoom);
            showPrint();
        }
    }
	
    public void play(){
    	Scanner in = new Scanner(System.in);
    	while ( true ) {
    		String line = in.nextLine();
    		String[] words = line.split(" ");
    		if ( words[0].equals("help") ) {
    			printHelp();
    		} else if (words[0].equals("go") ) {
    			goRoom(words[1]);
    		} else if ( words[0].equals("bye") ) {
    			break;
    		}
    		 System.out.println("��л���Ĺ��١��ټ���");
    	        in.close();
    	}
    }
	public static void main(String[] args) {
		
		Game game = new Game();
		game.printWelcome();
		game.play();
		
	}

}
