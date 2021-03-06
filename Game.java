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

        //  制造房间
        outside = new Room("城堡外");
        lobby = new Room("大堂");
        pub = new Room("小酒吧");
        study = new Room("书房");
        bedroom = new Room("卧室");

        //  初始化房间的出口(ps:可以方便的加入或删除任何方向)
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

        currentRoom = outside;  //  从城堡门外开始
    }

    private void printWelcome() {
        System.out.println();
        System.out.println("欢迎来到城堡！");
        System.out.println("这是一个超级无聊的游戏。");
        System.out.println("如果需要帮助，请输入 'help' 。");
        System.out.println();
        System.out.println("现在你在" + currentRoom);
        showPrint();
    }
    private void showPrint(){
    	 
         System.out.print("出口有: ");
         System.out.println(currentRoom.getExitDes());
         System.out.println();
    }
    // 以下为用户命令

    private void printHelp() 
    {
        System.out.print("迷路了吗？你可以做的命令有：go bye help");
        System.out.println("如：\tgo east");
    }

    private void goRoom(String direction) 
    {
        Room nextRoom = currentRoom.goExit(direction);
       
        if (nextRoom == null) {
            System.out.println("那里没有门！");
        }
        else {
            currentRoom = nextRoom;
            System.out.println("你在" + currentRoom);
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
	}
    		 System.out.println("感谢您的光临。再见！");
    	        in.close();
    	
    }
	public static void main(String[] args) {
		
		Game game = new Game();
		game.printWelcome();
		game.play();
		
	}

}
