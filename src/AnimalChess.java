/**
 * Created by LuoAoFang on 2016/10/20.
 * This file contains AnimalChess
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class AnimalChess {
    public static void main(String[] args) {
        char[][][] animal = new char[1000][7][9];
        char[][] map = new char[7][9];

        Scanner input = new Scanner(System.in);
        readMap(map);
        readAnimalMap(animal);
        printMap(map, animal, 0);
        int currentStep = 0;
        int lastStep = 0;

        while (currentStep >= 0) {
            //judge it's whose turn and prompt the user to enter the command
            System.out.print((currentStep % 2 == 0 ? "左" : "右") + "方玩家行动：");
            String command = input.nextLine();
            System.out.println(command);
            if (command.equals("help")) {
                printHelp();
            } else if (command.equals("exit")) {
                System.exit(0);
            } else if (command.equals("restart")) {
                printMap(map, animal, 0);
                currentStep = 0;
                lastStep = 0;
            } else if (command.equals("undo")) {
                if (currentStep > 0) {
                    printMap(map, animal, currentStep - 1);
                    currentStep -= 1;
                } else {
                    System.out.println("已经回到开局，不能再悔棋了！");
                }
            } else if (command.equals("redo")) {
                if (currentStep < lastStep) {
                    printMap(map, animal, currentStep + 1);
                    currentStep += 1;
                } else {
                    System.out.println("已经到最后记录，不能再取消悔棋了！");
                }
            } else if (command.length() == 2 ) {
                char i = command.charAt(0);
                char j = command.charAt(1);
                if (i >= '1' && i <= '8' && (j == 'w' || j == 'a' || j == 's' || j == 'd')) {
                    currentStep = nextMove(map, animal, i, j, currentStep, lastStep);
                } else System.out.println("不能识别指令，请重新输入！");
                if (currentStep > lastStep || currentStep < lastStep) {
                    lastStep = currentStep;    //after each legal move ,empty the gap between lastStep and currentStep
                }
            } else {
                System.out.println("不能识别指令，请重新输入！");
            }
        }
    }

    //print the whole map at the currentStep
    public static void printMap(char[][] map, char[][][] animal, int currentMap) {
        System.out.println("");
        for (int j = 0; j < 7; j++) {
            for (int i = 0; i < 9; i++) {
                char theCharMap = map[j][i];
                char theCharAnimal = animal[currentMap][j][i];
                switch (theCharAnimal) {
                    case '0':
                        switch (theCharMap) {
                            case '0':
                                System.out.print(" 　 ");
                                break;
                            case '1':
                                System.out.print(" 水 ");
                                break;
                            case '2':
                                System.out.print(" 陷 ");
                                break;
                            case '3':
                                System.out.print(" 家 ");
                                break;
                            case '4':
                                System.out.print(" 陷 ");
                                break;
                            case '5':
                                System.out.print(" 家 ");
                                break;

                            default:
                                System.out.println();
                        }
                        break;
                    case '1':
                        System.out.print("1鼠 ");
                        break;
                    case '2':
                        System.out.print("2猫 ");
                        break;
                    case '3':
                        System.out.print("3狼 ");
                        break;
                    case '4':
                        System.out.print("4狗 ");
                        break;
                    case '5':
                        System.out.print("5豹 ");
                        break;
                    case '6':
                        System.out.print("6虎 ");
                        break;
                    case '7':
                        System.out.print("7狮 ");
                        break;
                    case '8':
                        System.out.print("8象 ");
                        break;
                    case 'a':
                        System.out.print(" 鼠1");
                        break;
                    case 'b':
                        System.out.print(" 猫2");
                        break;
                    case 'c':
                        System.out.print(" 狼3");
                        break;
                    case 'd':
                        System.out.print(" 狗4");
                        break;
                    case 'e':
                        System.out.print(" 豹5");
                        break;
                    case 'f':
                        System.out.print(" 虎6");
                        break;
                    case 'g':
                        System.out.print(" 狮7");
                        break;
                    case 'h':
                        System.out.print(" 象8");
                        break;


                    default:
                        System.out.println();

                }
            }
            System.out.println("");
        }
    }

    //print the kind of animal of the specific chesspiece
    public static String printAnimal(char theCharAnimal) {
        switch (theCharAnimal) {
            case '1':
                return ("鼠");
            case '2':
                return ("猫");
            case '3':
                return ("狼");
            case '4':
                return ("狗");
            case '5':
                return ("豹");
            case '6':
                return ("虎");
            case '7':
                return ("狮");
            case '8':
                return ("象");
            case 'a':
                return ("鼠");
            case 'b':
                return ("猫");
            case 'c':
                return ("狼");
            case 'd':
                return ("狗");
            case 'e':
                return ("豹");
            case 'f':
                return ("虎");
            case 'g':
                return ("狮");
            case 'h':
                return ("象");

            default:
                System.out.println();
        }
        return "";
    }

    //print the identity of the specific chesspiece
    public static String printAnimal2(char theCharAnimal) {
        switch (theCharAnimal) {
            case '1':
                return ("1鼠 ");
            case '2':
                return ("2猫 ");
            case '3':
                return ("3狼 ");
            case '4':
                return ("4狗 ");
            case '5':
                return ("5豹 ");
            case '6':
                return ("6虎 ");
            case '7':
                return ("7狮 ");
            case '8':
                return ("8象 ");
            case 'a':
                return (" 鼠1");
            case 'b':
                return (" 猫2");
            case 'c':
                return (" 狼3");
            case 'd':
                return (" 狗4");
            case 'e':
                return (" 豹5");
            case 'f':
                return (" 虎6");
            case 'g':
                return (" 狮7");
            case 'h':
                return (" 象8");

            default:
                System.out.println();
        }
        return "";
    }

    //perform thr player's move and change the state of the board or state illegal move
    // return the currentStep after implementation
    public static int nextMove(char[][] map, char[][][] animal, char i, char j,
                               int currentStep,  int lastStep) {
        //copy the previous map
        for (int x = 0; x < 7; x++) {
            for (int y = 0; y < 9; y++) {
                animal[currentStep + 1][x][y] = animal[currentStep][x][y];
            }
        }
        if (currentStep % 2 == 0) {
            int existAnimal = 0; 
            for (int m = 0; m <= 6; m++) {
                for (int n = 0; n <= 8; n++) {
                    if (animal[currentStep][m][n] == i) {
                        existAnimal += 1;         //judge whether the specific chesspiece exists
                        switch (j) {
                            case 'w':
                                if (m > 0 && m <= 6) {
                                    if (map[m - 1][n] == '3') {
                                        System.out.println("不能进入己方兽穴");
                                        return currentStep;
                                    } else if (map[m - 1][n] == '5') { //如果上边是右方兽穴
                                        System.out.println("左方获得胜利");
                                        System.exit(0);
                                    } else if (animal[currentStep][m - 1][n] <= '8'
                                            && animal[currentStep][m - 1][n] != '0'
                                            && map[m - 1][n] != '1') {//如果上边是友方单位
                                        System.out.println("已有友方单位，不能进入：");
                                        return currentStep;
                                    } else if (((animal[currentStep][m - 1][n] <= animal[currentStep][m][n] + 48) &&
                                            (!(animal[currentStep][m - 1][n] == 'a' && animal[currentStep][m][n] == '8'
                                                    && map[m - 1][n] == '0')) ||
                                            (animal[currentStep][m - 1][n] == 'h' && animal[currentStep][m][n] == '1')
                                            || map[m - 1][n] == '2')) {  //如果上边是空地或是左方陷阱或是比所选中的左方动物弱小的右方动物
                                        if ((animal[currentStep][m][n] == '6' || animal[currentStep][m][n] == '7') &&
                                                map[m - 1][n] == '1') {//如果是狮子或老虎面对着河
                                            if (animal[currentStep][m - 1][n] == 'a' ||
                                                    animal[currentStep][m - 2][n] == 'a') {//如果河中有对方老虎
                                                System.out.println("河中有对方老鼠阻隔," +
                                                        printAnimal(animal[currentStep][m][n]) + "不能跳河！");
                                                return currentStep;
                                            } else if (animal[currentStep][m][n] >= animal[currentStep][m - 3][n] - 48) //如果对岸动物比狮子弱
                                            {   animal[currentStep + 1][m - 3][n] = i;
                                                animal[currentStep + 1][m][n] = '0';
                                                printMap(map, animal, currentStep + 1);
                                                eatUp(animal, currentStep);
                                                return (currentStep + 1);
                                            } else {                      //对岸动物比狮子强
                                                System.out.println(printAnimal(animal[currentStep][m][n]) + "打不过"
                                                        + printAnimal(animal[currentStep][m - 3][n]));
                                                return currentStep;
                                            }
                                        } else if (animal[currentStep][m - 1][n] != '1' && map[m - 1][n] != '1'
                                                || animal[currentStep][m][n] == '1' &&
                                                (!(animal[currentStep][m - 1][n] == 'h' && map[m][n] == '1'))) {
                                            //如果选中左方除鼠以外的动物且上边非河或选中左方老鼠且不是鼠在河中岸上是河对方大象的情形
                                            animal[currentStep + 1][m - 1][n] = i;
                                            animal[currentStep + 1][m][n] = '0';
                                            printMap(map, animal, currentStep + 1);
                                            eatUp(animal, currentStep);
                                            return (currentStep + 1);
                                        }  else {
                                            System.out.println(printAnimal(animal[currentStep][m][n]) + "不能下水");
                                            return currentStep;
                                        }
                                    } else if (animal[currentStep][m][n] == '1' && map[m][n] == '1' &&
                                            animal[currentStep][m - 1][n] == 'h') { //鼠在河中岸上是河对方大象的情形
                                        System.out.println("不能从水里攻击陆地上的象");
                                        return currentStep;
                                    } else {
                                        System.out.println(printAnimal(animal[currentStep][m][n]) + "打不过" +
                                                printAnimal(animal[currentStep][m - 1][n]));
                                        return currentStep;
                                    }
                                } else {
                                    System.out.println("不能越界");
                                    return currentStep;
                                }


                            case 'a':
                                if (n > 0 && n <= 8) {
                                     if (map[m][n - 1] == '3') {
                                        System.out.println("不能进入己方兽穴");
                                        return currentStep;
                                    } else if (map[m][n - 1] == '5') {
                                        System.out.println("左方获得胜利");
                                        System.exit(0);
                                    }else if (animal[currentStep][m][n - 1] <= '8' && animal[currentStep][m][n - 1] != '0'
                                            && map[m][n - 1] != '1') {
                                        System.out.println("已有友方单位，不能进入");
                                        return currentStep;
                                    } else if ((animal[currentStep][m][n - 1] <= animal[currentStep][m][n] + 48 &&
                                            (!(animal[currentStep][m][n - 1] == 'a' && animal[currentStep][m][n] == '8'
                                                    && map[m][n - 1] == '0')) ||
                                            (animal[currentStep][m][n - 1] == 'h' && animal[currentStep][m][n] == '1') ||
                                            map[m][n - 1] == '2')) {
                                        if ((animal[currentStep][m][n] == '6' || animal[currentStep][m][n] == '7') &&
                                                map[m][n - 1] == '1' && animal[currentStep][m][n - 1] != 'a'
                                                && animal[currentStep][m][n - 2] != 'a' &&
                                                animal[currentStep][m][n - 3] != 'a') {
                                            if (animal[currentStep][m][n] >= animal[currentStep][m][n - 4] - 48) {
                                                animal[currentStep + 1][m][n - 4] = i;
                                                animal[currentStep + 1][m][n] = '0';
                                                printMap(map, animal, currentStep + 1);
                                                eatUp(animal, currentStep);
                                                return (currentStep + 1);
                                            } else {
                                                System.out.println(printAnimal(animal[currentStep][m][n]) + "打不过" +
                                                        printAnimal(animal[currentStep][m][n - 4]));
                                                return currentStep;
                                            }
                                        } else if ((animal[currentStep][m][n] == '6' || animal[currentStep][m][n] == '7')
                                                && map[m][n - 1] == '1' && (animal[currentStep][m][n - 1] == 'a' ||
                                                animal[currentStep][m][n - 2] == 'a' ||
                                                animal[currentStep][m][n - 3] == 'a')) {
                                            System.out.println("河中有对方老鼠阻隔," +
                                                    printAnimal(animal[currentStep][m][n]) + "不能跳河！");
                                            return currentStep;
                                        } else if (animal[currentStep][m][n] != '1' && map[m][n - 1] != '1' ||
                                                (animal[currentStep][m][n] == '1'
                                                && (!(animal[currentStep][m][n - 1] == 'h'
                                                && map[m][n - 1] == '1')))) {
                                            animal[currentStep + 1][m][n - 1] = i;
                                            animal[currentStep + 1][m][n] = '0';
                                            printMap(map, animal, currentStep + 1);
                                            eatUp(animal, currentStep);
                                            return (currentStep + 1);
                                        } else if (animal[currentStep][m][n] == '1'
                                                && animal[currentStep][m][n - 1] == 'h'
                                                && map[m][n] == '1') {
                                            System.out.println("不能从水里攻击陆地上的象");
                                            return currentStep;
                                        } else {
                                            System.out.println(printAnimal(animal[currentStep][m][n]) + "不能下水");
                                            return currentStep;
                                        }
                                    }else {
                                        System.out.println(printAnimal(animal[currentStep][m][n]) + "打不过" +
                                                printAnimal(animal[currentStep][m][n - 1]));
                                        return currentStep;
                                    }
                                } else {
                                    System.out.println("不能越界");
                                    return currentStep;
                                }
                                break;


                            case 's':
                                if (m >= 0 && m < 6) {
                                     if (map[m + 1][n] == 3) {
                                        System.out.println("不能进入己方兽穴");
                                        return currentStep;
                                    } else if (map[m + 1][n] == '5') {
                                        System.out.println("左方获得胜利");
                                        System.exit(0);
                                    } else if (animal[currentStep][m + 1][n] <= '8'
                                             && animal[currentStep][m + 1][n] != '0'
                                            && map[m + 1][n] != '1') {
                                        System.out.println("已有友方单位，不能进入");
                                        return currentStep;
                                    } else if ((animal[currentStep][m + 1][n] <= animal[currentStep][m][n] + 48 &&
                                            (!(animal[currentStep][m + 1][n] == 'a' && animal[currentStep][m][n] == '8'
                                                    && map[m + 1][n] == '0')) ||
                                            (animal[currentStep][m + 1][n] == 'h' && animal[currentStep][m][n] == '1')
                                             || map[m + 1][n] == '2')) {
                                        if ((animal[currentStep][m][n] == '6' || animal[currentStep][m][n] == '7') &&
                                                map[m + 1][n] == '1' && animal[currentStep][m + 1][n] != 'a'
                                                && animal[currentStep][m + 2][n] != 'a') {
                                            if (animal[currentStep][m][n] >= animal[currentStep][m + 3][n] - 48) {
                                                animal[currentStep + 1][m + 3][n] = i;
                                                animal[currentStep + 1][m][n] = '0';
                                                printMap(map, animal, currentStep + 1);
                                                eatUp(animal, currentStep);
                                                return (currentStep + 1);
                                            } else {
                                                System.out.println(printAnimal(animal[currentStep][m][n]) + "打不过"
                                                        + printAnimal(animal[currentStep][m + 3][n]));
                                                return currentStep;
                                            }
                                        } else if ((animal[currentStep][m][n] == '6' ||
                                                animal[currentStep][m][n] == '7') &&
                                                map[m + 1][n] == '1' && (animal[currentStep][m + 1][n] == 'a' ||
                                                animal[currentStep][m + 2][n] == 'a')) {
                                            System.out.println("河中有对方老鼠阻隔," +
                                                    printAnimal(animal[currentStep][m][n]) + "不能跳河！");
                                            return currentStep;
                                        } else if ((animal[currentStep][m][n] != '1' && map[m + 1][n] != '1') ||
                                                (animal[currentStep][m][n] == '1'
                                                        && (!(animal[currentStep][m + 1][n] == 'h'
                                                        && map[m][n] == '1')))) {
                                            animal[currentStep + 1][m + 1][n] = i;
                                            animal[currentStep + 1][m][n] = '0';
                                            printMap(map, animal, currentStep + 1);
                                            eatUp(animal, currentStep);
                                            return (currentStep + 1);
                                        } else if (animal[currentStep][m][n] == '1' && map[m][n] == '1' &&
                                                animal[currentStep][m + 1][n] == 'h') {
                                            System.out.println("不能从水里攻击陆地上的象");
                                            return currentStep;
                                        } else {
                                            System.out.println(printAnimal(animal[currentStep][m][n]) + "不能下水");
                                            return currentStep;
                                        }
                                    } else {
                                        System.out.println(printAnimal(animal[currentStep][m][n]) + "打不过" +
                                                printAnimal(animal[currentStep][m + 1][n]));
                                        return currentStep;
                                    }
                                } else {
                                    System.out.println("不能越界");
                                    return currentStep;
                                }
                                break;


                            case 'd':
                                if (n >= 0 && n < 8) {
                                    if (animal[currentStep][m][n + 1] <= '8' && animal[currentStep][m][n + 1] != '0'
                                            && map[m][n + 1] != '1') {
                                        System.out.println("已有友方单位，不能进入");
                                        return currentStep;
                                    } else if ((animal[currentStep][m][n + 1] <= animal[currentStep][m][n] + 48 &&
                                            (!(animal[currentStep][m][n + 1] == 'a' && animal[currentStep][m][n] == '8'
                                                    && map[m][n + 1] == '0')) ||
                                            (animal[currentStep][m][n + 1] == 'h' && animal[currentStep][m][n] == '1') ||
                                            map[m][n + 1] == '2') && (map[m][n + 1] != '3') &&
                                            map[m][n + 1] != '5') {
                                        if ((animal[currentStep][m][n] == '6' || animal[currentStep][m][n] == '7') &&
                                                map[m][n + 1] == '1' && animal[currentStep][m][n + 1] != 'a'
                                                && animal[currentStep][m][n + 2] != 'a'
                                                && animal[currentStep][m][n + 3] != 'a') {
                                            if (animal[currentStep][m][n] >= animal[currentStep][m][n + 4] - 48) {
                                                animal[currentStep + 1][m][n + 4] = i;
                                                animal[currentStep + 1][m][n] = '0';
                                                printMap(map, animal, currentStep + 1);
                                                eatUp(animal, currentStep);
                                                return (currentStep + 1);
                                            } else {
                                                System.out.println(printAnimal(animal[currentStep][m][n]) + "打不过"
                                                        + printAnimal(animal[currentStep][m][n + 4]));
                                                return currentStep;
                                            }
                                        } else if ((animal[currentStep][m][n] == '6'
                                                || animal[currentStep][m][n] == '7') &&
                                                map[m][n + 1] == '1' && (animal[currentStep][m][n + 1] == 'a' ||
                                                animal[currentStep][m][n + 2] == 'a'
                                                || animal[currentStep][m][n + 3] == 'a')) {
                                            System.out.println("河中有对方老鼠阻隔," +
                                                    printAnimal(animal[currentStep][m][n]) + "不能跳河！");
                                            return currentStep;
                                        } else if ((animal[currentStep][m][n] != '1' && map[m][n + 1] != '1') ||
                                                (animal[currentStep][m][n] == '1'
                                                        && (!(animal[currentStep][m][n + 1] == 'h'
                                                        && map[m][n] == '1')))) {
                                            animal[currentStep + 1][m][n + 1] = i;
                                            animal[currentStep + 1][m][n] = '0';
                                            printMap(map, animal, currentStep + 1);
                                            eatUp(animal, currentStep);
                                            return (currentStep + 1);
                                        } else {
                                            System.out.println(printAnimal(animal[currentStep][m][n]) + "不能下水");
                                            return currentStep;
                                        }
                                    } else if (animal[currentStep][m][n] == '1' && map[m][n] == '1' &&
                                            animal[currentStep][m][n + 1] == 'h') {
                                        System.out.println("不能从水里攻击陆地上的象");
                                        return currentStep;
                                    } else if (map[m][n + 1] == '3') {
                                        System.out.println("不能进入己方兽穴");
                                        return currentStep;
                                    } else if (map[m][n + 1] == '5') {
                                        System.out.println("左方获得胜利");
                                        System.exit(0);
                                    } else {
                                        System.out.println(printAnimal(animal[currentStep][m][n]) + "打不过" +
                                                printAnimal(animal[currentStep][m][n + 1]));
                                        return currentStep;
                                    }
                                } else {
                                    System.out.println("不能越界");
                                    return currentStep;
                                }
                                break;


                            default:
                                System.out.println();
                        }
                    }
                }
            }
            if (existAnimal == 0) {
                System.out.println(printAnimal2(i) + "已被消灭");
                return currentStep;
            }
        } else if (currentStep % 2 == 1) {
            int existAnimal = 0;
            for (int m = 0; m <= 6; m++) {
                for (int n = 0; n <= 8; n++) {
                    if (animal[currentStep][m][n] == i + 48) {
                        existAnimal += 1;
                        switch (j) {
                            case 'w':
                                if (m > 0 && m <= 6) {
                                    if (animal[currentStep][m - 1][n] >= 'a' && map[m - 1][n] != '1') {
                                        System.out.println("已有友方单位，不能进入");
                                        return currentStep;
                                    } else if ((animal[currentStep][m - 1][n] <= animal[currentStep][m][n] - 48 &&
                                            (!(animal[currentStep][m - 1][n] == '1' && animal[currentStep][m][n] == 'h'
                                                    && map[m - 1][n] == '0')) || map[m - 1][n] == '4'
                                            || (animal[currentStep][m - 1][n] == '8' && animal[currentStep][m][n] == 'a'))
                                            && map[m - 1][n] != '5' && map[m - 1][n] != '3') {
                                        if ((animal[currentStep][m][n] == 'f' || animal[currentStep][m][n] == 'g') &&
                                                map[m - 1][n] == '1' && animal[currentStep][m - 1][n] != '1'
                                                && animal[currentStep][m - 2][n] != '1') {
                                            if (animal[currentStep][m][n] >= animal[currentStep][m - 3][n] + 48) {
                                                animal[currentStep + 1][m - 3][n] = (char) (i + 48);
                                                animal[currentStep + 1][m][n] = '0';
                                                printMap(map, animal, currentStep + 1);
                                                eatUp(animal, currentStep);
                                                return (currentStep + 1);
                                            } else {
                                                System.out.println(printAnimal(animal[currentStep][m][n]) + "打不过"
                                                        + printAnimal(animal[currentStep][m - 3][n]));
                                                return currentStep;
                                            }
                                        } else if ((animal[currentStep][m][n] == 'f' || animal[currentStep][m][n] == 'g')
                                                && map[m - 1][n] == '1' && (animal[currentStep][m - 1][n] == '1' ||
                                                animal[currentStep][m - 2][n] == '1')) {
                                            System.out.println("河中有对方老鼠阻隔," +
                                                    printAnimal(animal[currentStep][m][n]) + "不能跳河！");
                                            return currentStep;
                                        } else if ((animal[currentStep][m][n] != 'a' && map[m - 1][n] != '1') ||
                                                (animal[currentStep][m][n] == 'a' && (!(animal[currentStep][m - 1][n]
                                                        == '8' && map[m][n] == '1')))) {
                                            animal[currentStep + 1][m - 1][n] = (char) (i + 48);
                                            animal[currentStep + 1][m][n] = '0';
                                            printMap(map, animal, currentStep + 1);
                                            eatUp(animal, currentStep);
                                            return (currentStep + 1);
                                        } else {
                                            System.out.println(printAnimal(animal[currentStep][m][n]) + "不能下水");
                                            return currentStep;
                                        }
                                    } else if (animal[currentStep][m][n] == 'a' && map[m][n] == '1' &&
                                            animal[currentStep][m][n] == '8') {
                                        System.out.println("不能从水里攻击陆地上的象");
                                        return currentStep;
                                    } else if (map[m - 1][n] == '5') {
                                        System.out.println("不能进入己方兽穴");
                                        return currentStep;
                                    } else if (map[m - 1][n] == '3') {
                                        System.out.println("右方获得胜利");
                                        System.exit(0);
                                    } else {
                                        System.out.println(printAnimal(animal[currentStep][m][n]) + "打不过"
                                                + printAnimal(animal[currentStep][m - 1][n]));
                                        return currentStep;
                                    }
                                } else {
                                    System.out.println("不能越界");
                                    return currentStep;
                                }
                                break;


                            case 'a':
                                if (n > 0 && n <= 8) {
                                    if (animal[currentStep][m][n - 1] >= 'a' && map[m][n - 1] != '1') {
                                        System.out.println("已有友方单位，不能进入");
                                        return currentStep;
                                    } else if ((animal[currentStep][m][n - 1] <= animal[currentStep][m][n] - 48) &&
                                            (!(animal[currentStep][m][n - 1] == '1' && animal[currentStep][m][n] == 'h'
                                                    && map[m][n - 1] == '0')) || (map[m][n - 1] == '4') ||
                                            (animal[currentStep][m][n - 1] == '8' && animal[currentStep][m][n] == 'a')
                                                    && (map[m][n - 1] != '5')
                                                    && animal[currentStep][m][n - 1] != '3') {
                                        if ((animal[currentStep][m][n] == 'f' || animal[currentStep][m][n] == 'g') &&
                                                map[m][n - 1] == '1' && animal[currentStep][m][n - 1] != '1'
                                                && animal[currentStep][m][n - 2] != '1' &&
                                                animal[currentStep][m][n - 3] != '1') {
                                            if (animal[currentStep][m][n] >= animal[currentStep][m][n - 4] + 48) {
                                                animal[currentStep + 1][m][n - 4] = (char) (i + 48);
                                                animal[currentStep + 1][m][n] = '0';
                                                printMap(map, animal, currentStep + 1);
                                                eatUp(animal, currentStep);
                                                return (currentStep + 1);
                                            } else {
                                                System.out.println(printAnimal(animal[currentStep][m][n]) + "打不过" +
                                                        printAnimal(animal[currentStep][m][n - 4]));
                                                return currentStep;
                                            }
                                        } else if ((animal[currentStep][m][n] == 'f' || animal[currentStep][m][n] == 'g')
                                                && map[m][n - 1] == '1' && (animal[currentStep][m][n - 1] == '1' ||
                                                animal[currentStep][m][n - 2] == '1' ||
                                                animal[currentStep][m][n - 3] == '1')) {
                                            System.out.println("河中有对方老鼠阻隔," +
                                                    printAnimal(animal[currentStep][m][n]) + "不能跳河！");
                                            return currentStep;
                                        } else if ((animal[currentStep][m][n] != 'a' && map[m][n - 1] != '1') ||
                                                (animal[currentStep][m][n] == 'a' &&
                                                        (!(animal[currentStep][m][n - 1] == '8' && map[m][n] == '1')))) {
                                            animal[currentStep + 1][m][n - 1] = (char) (i + 48);
                                            animal[currentStep + 1][m][n] = '0';
                                            printMap(map, animal, currentStep + 1);
                                            eatUp(animal, currentStep);
                                            return (currentStep + 1);
                                        } else {
                                            System.out.println(printAnimal(animal[currentStep][m][n]) + "不能下水");
                                            return currentStep;
                                        }
                                    } else if (animal[currentStep][m][n] == 'a' && map[m][n] == '1'
                                            && animal[currentStep][m][n] == '8') {
                                        System.out.println("不能从水里攻击陆地上的象");
                                        return currentStep;
                                    } else if (map[m][n - 1] == '5') {
                                        System.out.println("不能进入己方兽穴");
                                        return currentStep;
                                    } else if (map[m][n - 1] == '3') {
                                        System.out.println("右方获得胜利");
                                        System.exit(0);
                                    } else {
                                        System.out.println(printAnimal(animal[currentStep][m][n]) + "打不过" +
                                                printAnimal(animal[currentStep][m][n - 1]));
                                        return currentStep;
                                    }
                                } else {
                                    System.out.println("不能越界");
                                    return currentStep;
                                }
                                break;


                            case 's':
                                if (m >= 0 && m < 6) {
                                    if (animal[currentStep][m + 1][n] >= 'a' && map[m + 1][n] != '1') {
                                        System.out.println("已有友方单位，不能进入");
                                        return currentStep;
                                    } else if (((animal[currentStep][m + 1][n] <= animal[currentStep][m][n] - 48) &&
                                            (!(animal[currentStep][m + 1][n] == '1' && animal[currentStep][m][n] == 'h'
                                                    && map[m + 1][n] == '0')) || map[m + 1][n] == '4'
                                            || (animal[currentStep][m + 1][n] == '8' && animal[currentStep][m][n] == 'a'))
                                            && (map[m + 1][n] != '5') && map[m + 1][n] != '3') {
                                        if ((animal[currentStep][m][n] == 'f' || animal[currentStep][m][n] == 'g') &&
                                                map[m + 1][n] == '1' && animal[currentStep][m + 1][n] != '1' &&
                                                animal[currentStep][m + 2][n] != '1') {
                                            if (animal[currentStep][m][n] >= animal[currentStep][m + 3][n] + 48) {
                                                animal[currentStep + 1][m + 3][n] = (char) (i + 48);
                                                animal[currentStep + 1][m][n] = '0';
                                                printMap(map, animal, currentStep + 1);
                                                eatUp(animal, currentStep);
                                                return (currentStep + 1);
                                            } else {
                                                System.out.println(printAnimal(animal[currentStep][m][n]) + "打不过" +
                                                        printAnimal(animal[currentStep][m + 3][n]));
                                                return currentStep;
                                            }
                                        } else if ((animal[currentStep][m][n] == 'f' ||
                                                animal[currentStep][m][n] == 'g') &&
                                                map[m + 1][n] == '1' && (animal[currentStep][m + 1][n] == '1' ||
                                                animal[currentStep][m + 2][n] == '1')) {
                                            System.out.println("河中有对方老鼠阻隔," +
                                                    printAnimal(animal[currentStep][m][n]) + "不能跳河！");
                                            return currentStep;
                                        } else if ((animal[currentStep][m][n] != 'a' && map[m + 1][n] != '1') ||
                                                (animal[currentStep][m][n] == 'a'
                                                        && (!(animal[currentStep][m + 1][n] == '8'
                                                        && map[m][n] == '1')))) {
                                            animal[currentStep + 1][m + 1][n] = (char) (i + 48);
                                            animal[currentStep + 1][m][n] = '0';
                                            printMap(map, animal, currentStep + 1);
                                            eatUp(animal, currentStep);
                                            return (currentStep + 1);
                                        } else {
                                            System.out.println(printAnimal(animal[currentStep][m][n]) + "不能下水");
                                            return currentStep;
                                        }
                                    } else if (animal[currentStep][m][n] == 'a' && map[m][n] == '1' &&
                                            animal[currentStep][m + 1][n] == '8') {
                                        System.out.println("不能从水里攻击陆地上的象");
                                        return currentStep;
                                    } else if (map[m + 1][n] == '5') {
                                        System.out.println("不能进入己方兽穴");
                                        return currentStep;
                                    } else if (map[m + 1][n] == '3') {
                                        System.out.println("右方获得胜利");
                                        System.exit(0);
                                    } else {
                                        System.out.println(printAnimal(animal[currentStep][m][n]) + "打不过"
                                                + printAnimal(animal[currentStep][m + 1][n]));
                                        return currentStep;
                                    }
                                } else {
                                    System.out.println("不能越界");
                                    return currentStep;
                                }
                                break;


                            case 'd':
                                if (n >= 0 && n < 8) {
                                    if (map[m][n + 1] == '5') {
                                    System.out.println("不能进入己方兽穴");
                                    return currentStep;
                                } else if (map[m][n + 1] == '3') {
                                    System.out.println("右方获得胜利");
                                    System.exit(0);
                                } else if (animal[currentStep][m][n + 1] >= 'a' && map[m][n + 1] != '1') {
                                        System.out.println("已有友方单位，不能进入");
                                        return currentStep;
                                    } else if (((animal[currentStep][m][n + 1] <= animal[currentStep][m][n] - 48) &&
                                            (!(animal[currentStep][m][n + 1] == '1' && animal[currentStep][m][n] == 'h'
                                                    && map[m][n + 1] == '0')) || map[m][n + 1] == '4' ||
                                            (animal[currentStep][m][n + 1] == '8' && animal[currentStep][m][n] == 'a')))
                                    {
                                        if ((animal[currentStep][m][n] == 'f' || animal[currentStep][m][n] == 'g') &&
                                                map[m][n + 1] == '1' && animal[currentStep][m][n + 1] != '1'
                                                && animal[currentStep][m][n + 2] != '1' &&
                                                animal[currentStep][m][n + 3] != '1') {
                                            if (animal[currentStep][m][n] >= animal[currentStep][m][n + 4] + 48) {
                                                animal[currentStep + 1][m][n + 4] = (char) (i + 48);
                                                animal[currentStep + 1][m][n] = '0';
                                                printMap(map, animal, currentStep + 1);
                                                eatUp(animal, currentStep);
                                                return (currentStep + 1);
                                            } else {
                                                System.out.println(printAnimal(animal[currentStep][m][n]) + "打不过"
                                                        + printAnimal(animal[currentStep][m][n + 4]));
                                                return currentStep;
                                            }
                                        } else if ((animal[currentStep][m][n] == 'f' || animal[currentStep][m][n] == 'g')
                                                && map[m][n + 1] == '1' && (animal[currentStep][m][n + 1] == '1' ||
                                                animal[currentStep][m][n + 2] == '1' ||
                                                animal[currentStep][m][n + 3] == '1')) {
                                            System.out.println("河中有对方老鼠阻隔," +
                                                    printAnimal(animal[currentStep][m][n]) + "不能跳河！");
                                            return currentStep;
                                        } else if ((animal[currentStep][m][n] != 'a' && map[m][n + 1] != '1') ||
                                                (animal[currentStep][m][n] == 'a' &&
                                                        (!(animal[currentStep][m][n + 1] == '8' && map[m][n] == '1')))) {
                                            animal[currentStep + 1][m][n + 1] = (char) (i + 48);
                                            animal[currentStep + 1][m][n] = '0';
                                            printMap(map, animal, currentStep + 1);
                                            eatUp(animal, currentStep);
                                            return (currentStep + 1);
                                        } else {
                                            System.out.println(printAnimal(animal[currentStep][m][n]) + "不能下水");
                                            return currentStep;
                                        }
                                    } else if (animal[currentStep][m][n] == 'a' && map[m][n] == '1' &&
                                            animal[currentStep][m][n + 1] == '8') {
                                        System.out.println("不能从水里攻击陆地上的象");
                                        return currentStep;
                                    }  else {
                                        System.out.println(printAnimal(animal[currentStep][m][n]) + "打不过"
                                                + printAnimal(animal[currentStep][m][n + 1]));
                                        return currentStep;
                                    }
                                } else {
                                    System.out.println("不能越界");
                                    return currentStep;
                                }

                            default:
                                System.out.println();
                        }
                    }
                }
            }
            if (existAnimal == 0) {
                System.out.println(printAnimal2(i) + "已被消灭");
                return currentStep;
            }
        }
        return currentStep;
    }
    //read and initialize the landmap
    public static char[][] readMap(char[][] map) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("tile.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    //read the data per line
        String firstLine = scanner.nextLine();
        String secondLine = scanner.nextLine();
        String thirdLine = scanner.nextLine();
        String fourthLine = scanner.nextLine();
        String fifthLine = scanner.nextLine();
        String sixthLine = scanner.nextLine();
        String seventhLine = scanner.nextLine();
        String[] mapPerLine = {firstLine, secondLine, thirdLine, fourthLine, fifthLine, sixthLine, seventhLine};

        for (int j = 0; j < 7; j++) {
            for (int i = 0; i < mapPerLine[j].length(); i++) {
                map[j][i] = mapPerLine[j].charAt(i);
            }
        }
        return (map);
    }
    // read and initialize the animalmap
    public static char[][][] readAnimalMap(char[][][] animal) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("animal1.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String first_Line = scanner.nextLine();
        String second_Line = scanner.nextLine();
        String third_Line = scanner.nextLine();
        String fourth_Line = scanner.nextLine();
        String fifth_Line = scanner.nextLine();
        String sixth_Line = scanner.nextLine();
        String seventh_Line = scanner.nextLine();
        String[] animalPerLine = {first_Line, second_Line, third_Line,
                fourth_Line, fifth_Line, sixth_Line, seventh_Line};

        for (int j = 0; j < 7; j++) {
            for (int i = 0; i < animalPerLine[j].length(); i++) {
                animal[0][j][i] = animalPerLine[j].charAt(i);
            }
        }
        return (animal);
    }
    //show help
    public static void printHelp() {
        System.out.println("指令介绍:");
        System.out.println("");
        System.out.println("1.移动指令");
        System.out.println("    移动指令由两个部分组成");
        System.out.println("    第一个部分是数字1-8，根据战斗力分别对应鼠（1），猫（2），" +
                "狼（3），狗（4），豹（5），虎（6），狮（7），象（8）");
        System.out.println("    第二个部分是字母wasd中的一个，w对应上方向，a对应左方向，" +
                "s对应下方向，d对应右方向");
        System.out.println("    比如指令“1d”表示鼠向右走，“4w”表示狗向上走");
        System.out.println("");
        System.out.println("2.游戏指令");
        System.out.println("    输入restart重新开始游戏");
        System.out.println("    输入help查看帮助");
        System.out.println("    输入undo悔棋");
        System.out.println("    输入redo取消悔棋");
        System.out.println("    输入exit退出游戏");
        System.out.println("");
    }

    //judge whether all the animals at one side have been killed
    public static void eatUp(char[][][] animal, int currentStep) {
        int h = 0;
        int t = 0;
        for (int o = 0; o < 7; o++) {
            for (int s = 0; s < 9; s++) {
                if (animal[currentStep + 1][o][s] >= '1' && animal[currentStep + 1][o][s] <= '8') {
                    h += 1;
                } else if (animal[currentStep + 1][o][s] >= 'a' && animal[currentStep + 1][o][s] <= 'h') {
                    t += 1;
                }
            }
        }
        if (h == 0) {
            System.out.println("右方获得胜利");
            System.exit(0);
        } else if (t == 0) {
            System.out.println("左方获得胜利");
            System.exit(0);
        }
    }
}