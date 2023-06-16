package aeroplane;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileWriter;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class Question4Tests {

  /*
  private static final String EXPECTED_RESULT_1 =
      "01A -> Crew member: CrewFirstname0 CrewSurname0\n"
          + "01B -> Crew member: CrewFirstname1 CrewSurname1\n"
          + "01C -> Crew member: CrewFirstname2 CrewSurname2\n"
          + "01D -> Crew member: CrewFirstname3 CrewSurname3\n"
          + "01E -> Crew member: CrewFirstname4 CrewSurname4\n"
          + "01F -> Crew member: CrewFirstname5 CrewSurname5\n"
          + "02A -> Business class passenger: BusinessFirstname0 BusinessSurname0,"
          + " age 18, likes truffles\n"
          + "02B -> Business class passenger: BusinessFirstname1 BusinessSurname1,"
          + " age 19, likes truffles\n"
          + "02C -> Business class passenger: BusinessFirstname2 BusinessSurname2,"
          + " age 20, likes truffles\n"
          + "02D -> Business class passenger: BusinessFirstname3 BusinessSurname3,"
          + " age 21, likes truffles\n"
          + "02E -> Business class passenger: BusinessFirstname4 BusinessSurname4,"
          + " age 22, likes truffles\n"
          + "02F -> Business class passenger: BusinessFirstname5 BusinessSurname5,"
          + " age 23, likes truffles\n"
          + "03A -> Business class passenger: BusinessFirstname6 BusinessSurname6,"
          + " age 24, likes truffles\n"
          + "03B -> Business class passenger: BusinessFirstname7 BusinessSurname7,"
          + " age 25, likes truffles\n"
          + "03C -> Business class passenger: BusinessFirstname8 BusinessSurname8,"
          + " age 26, likes truffles\n"
          + "03D -> Business class passenger: BusinessFirstname9 BusinessSurname9,"
          + " age 27, likes truffles\n"
          + "03E -> Business class passenger: BusinessFirstname10 BusinessSurname10,"
          + " age 28, likes truffles\n"
          + "03F -> Business class passenger: BusinessFirstname11 BusinessSurname11,"
          + " age 29, likes truffles\n"
          + "04A -> Business class passenger: BusinessFirstname12 BusinessSurname12,"
          + " age 30, likes truffles\n"
          + "04B -> Business class passenger: BusinessFirstname13 BusinessSurname13,"
          + " age 31, likes truffles\n"
          + "04C -> Business class passenger: BusinessFirstname14 BusinessSurname14,"
          + " age 32, likes truffles\n"
          + "04D -> Business class passenger: BusinessFirstname15 BusinessSurname15,"
          + " age 33, likes truffles\n"
          + "04E -> Business class passenger: BusinessFirstname16 BusinessSurname16,"
          + " age 34, likes truffles\n"
          + "04F -> Business class passenger: BusinessFirstname17 BusinessSurname17,"
          + " age 35, likes truffles\n"
          + "05A -> Business class passenger: BusinessFirstname18 BusinessSurname18,"
          + " age 36, likes truffles\n"
          + "05B -> Business class passenger: BusinessFirstname19 BusinessSurname19,"
          + " age 37, likes truffles\n"
          + "05C -> Business class passenger: BusinessFirstname20 BusinessSurname20,"
          + " age 38, likes truffles\n"
          + "05D -> Business class passenger: BusinessFirstname21 BusinessSurname21,"
          + " age 39, likes truffles\n"
          + "05E -> Business class passenger: BusinessFirstname22 BusinessSurname22,"
          + " age 40, likes truffles\n"
          + "05F -> Business class passenger: BusinessFirstname23 BusinessSurname23,"
          + " age 41, likes truffles\n"
          + "06A -> Business class passenger: BusinessFirstname24 BusinessSurname24,"
          + " age 42, likes truffles\n"
          + "06B -> Business class passenger: BusinessFirstname25 BusinessSurname25,"
          + " age 43, likes truffles\n"
          + "06C -> Business class passenger: BusinessFirstname26 BusinessSurname26,"
          + " age 44, likes truffles\n"
          + "06D -> Business class passenger: BusinessFirstname27 BusinessSurname27,"
          + " age 45, likes truffles\n"
          + "06E -> Business class passenger: BusinessFirstname28 BusinessSurname28,"
          + " age 46, likes truffles\n"
          + "06F -> Business class passenger: BusinessFirstname29 BusinessSurname29,"
          + " age 47, likes truffles\n"
          + "07A -> Business class passenger: BusinessFirstname30 BusinessSurname30,"
          + " age 48, likes truffles\n"
          + "07B -> Business class passenger: BusinessFirstname31 BusinessSurname31,"
          + " age 49, likes truffles\n"
          + "07C -> Business class passenger: BusinessFirstname32 BusinessSurname32,"
          + " age 50, likes truffles\n"
          + "07D -> Business class passenger: BusinessFirstname33 BusinessSurname33,"
          + " age 51, likes truffles\n"
          + "07E -> Business class passenger: BusinessFirstname34 BusinessSurname34,"
          + " age 52, likes truffles\n"
          + "07F -> Business class passenger: BusinessFirstname35 BusinessSurname35,"
          + " age 53, likes truffles\n"
          + "08A -> Business class passenger: BusinessFirstname36 BusinessSurname36,"
          + " age 54, likes truffles\n"
          + "08B -> Business class passenger: BusinessFirstname37 BusinessSurname37,"
          + " age 55, likes truffles\n"
          + "08C -> Business class passenger: BusinessFirstname38 BusinessSurname38,"
          + " age 56, likes truffles\n"
          + "08D -> Business class passenger: BusinessFirstname39 BusinessSurname39,"
          + " age 57, likes truffles\n"
          + "08E -> Business class passenger: BusinessFirstname40 BusinessSurname40,"
          + " age 58, likes truffles\n"
          + "08F -> Business class passenger: BusinessFirstname41 BusinessSurname41,"
          + " age 59, likes truffles\n"
          + "09A -> Business class passenger: BusinessFirstname42 BusinessSurname42,"
          + " age 60, likes truffles\n"
          + "09B -> Business class passenger: BusinessFirstname43 BusinessSurname43,"
          + " age 61, likes truffles\n"
          + "09C -> Business class passenger: BusinessFirstname44 BusinessSurname44,"
          + " age 62, likes truffles\n"
          + "09D -> Business class passenger: BusinessFirstname45 BusinessSurname45,"
          + " age 63, likes truffles\n"
          + "09E -> Business class passenger: BusinessFirstname46 BusinessSurname46,"
          + " age 64, likes truffles\n"
          + "09F -> Business class passenger: BusinessFirstname47 BusinessSurname47,"
          + " age 65, likes truffles\n"
          + "11A -> Business class passenger: ChildBusinessFirstname0 ChildBusinessSurname0,"
          + " age 0, likes strawberries\n"
          + "11B -> Business class passenger: ChildBusinessFirstname1 ChildBusinessSurname1,"
          + " age 1, likes strawberries\n"
          + "11C -> Business class passenger: ChildBusinessFirstname2 ChildBusinessSurname2,"
          + " age 2, likes strawberries\n"
          + "11D -> Business class passenger: ChildBusinessFirstname3 ChildBusinessSurname3,"
          + " age 3, likes strawberries\n"
          + "11E -> Business class passenger: ChildBusinessFirstname4 ChildBusinessSurname4,"
          + " age 4, likes strawberries\n"
          + "11F -> Business class passenger: ChildBusinessFirstname5 ChildBusinessSurname5,"
          + " age 5, likes strawberries\n"
          + "12A -> Business class passenger: ChildBusinessFirstname6 ChildBusinessSurname6,"
          + " age 6, likes strawberries\n"
          + "12B -> Business class passenger: ChildBusinessFirstname7 ChildBusinessSurname7,"
          + " age 7, likes strawberries\n"
          + "12C -> Business class passenger: ChildBusinessFirstname8 ChildBusinessSurname8,"
          + " age 8, likes strawberries\n"
          + "12D -> Business class passenger: ChildBusinessFirstname9 ChildBusinessSurname9,"
          + " age 9, likes strawberries\n"
          + "12E -> Business class passenger: ChildBusinessFirstname10 ChildBusinessSurname10,"
          + " age 10, likes strawberries\n"
          + "12F -> Business class passenger: ChildBusinessFirstname11 ChildBusinessSurname11,"
          + " age 11, likes strawberries\n"
          + "13A -> Business class passenger: ChildBusinessFirstname12 ChildBusinessSurname12,"
          + " age 12, likes strawberries\n"
          + "13B -> Business class passenger: ChildBusinessFirstname13 ChildBusinessSurname13,"
          + " age 13, likes strawberries\n"
          + "13C -> Business class passenger: ChildBusinessFirstname14 ChildBusinessSurname14,"
          + " age 14, likes strawberries\n"
          + "13D -> Business class passenger: ChildBusinessFirstname15 ChildBusinessSurname15,"
          + " age 15, likes strawberries\n"
          + "13E -> Business class passenger: ChildBusinessFirstname16 ChildBusinessSurname16,"
          + " age 16, likes strawberries\n"
          + "13F -> Business class passenger: ChildBusinessFirstname17 ChildBusinessSurname17,"
          + " age 17, likes strawberries\n"
          + "14A -> Business class passenger: ChildBusinessFirstname18 ChildBusinessSurname18,"
          + " age 0, likes strawberries\n"
          + "14B -> Business class passenger: ChildBusinessFirstname19 ChildBusinessSurname19,"
          + " age 1, likes strawberries\n"
          + "14C -> Business class passenger: ChildBusinessFirstname20 ChildBusinessSurname20,"
          + " age 2, likes strawberries\n"
          + "14D -> Business class passenger: ChildBusinessFirstname21 ChildBusinessSurname21,"
          + " age 3, likes strawberries\n"
          + "14E -> Business class passenger: ChildBusinessFirstname22 ChildBusinessSurname22,"
          + " age 4, likes strawberries\n"
          + "14F -> Business class passenger: ChildBusinessFirstname23 ChildBusinessSurname23,"
          + " age 5, likes strawberries\n"
          + "15A -> Business class passenger: ChildBusinessFirstname24 ChildBusinessSurname24,"
          + " age 6, likes strawberries\n"
          + "15B -> Business class passenger: ChildBusinessFirstname25 ChildBusinessSurname25,"
          + " age 7, likes strawberries\n"
          + "15C -> Business class passenger: ChildBusinessFirstname26 ChildBusinessSurname26,"
          + " age 8, likes strawberries\n"
          + "15D -> Business class passenger: ChildBusinessFirstname27 ChildBusinessSurname27,"
          + " age 9, likes strawberries\n"
          + "15E -> Business class passenger: ChildBusinessFirstname28 ChildBusinessSurname28,"
          + " age 10, likes strawberries\n"
          + "15F -> Business class passenger: ChildBusinessFirstname29 ChildBusinessSurname29,"
          + " age 11, likes strawberries\n";

  private static final String EXPECTED_RESULT_2 =
      "16A -> Economy class passenger: EconomyFirstname0 EconomySurname0,"
          + " age 0\n"
          + "16B -> Economy class passenger: EconomyFirstname1 EconomySurname1,"
          + " age 1\n"
          + "16C -> Economy class passenger: EconomyFirstname2 EconomySurname2,"
          + " age 2\n"
          + "16D -> Economy class passenger: EconomyFirstname3 EconomySurname3,"
          + " age 3\n"
          + "16E -> Economy class passenger: EconomyFirstname4 EconomySurname4,"
          + " age 4\n"
          + "16F -> Economy class passenger: EconomyFirstname5 EconomySurname5,"
          + " age 5\n"
          + "17A -> Economy class passenger: EconomyFirstname6 EconomySurname6,"
          + " age 6\n"
          + "17B -> Economy class passenger: EconomyFirstname7 EconomySurname7,"
          + " age 7\n"
          + "17C -> Economy class passenger: EconomyFirstname8 EconomySurname8,"
          + " age 8\n"
          + "17D -> Economy class passenger: EconomyFirstname9 EconomySurname9,"
          + " age 9\n"
          + "17E -> Economy class passenger: EconomyFirstname10 EconomySurname10,"
          + " age 10\n"
          + "17F -> Economy class passenger: EconomyFirstname11 EconomySurname11,"
          + " age 11\n"
          + "18A -> Economy class passenger: EconomyFirstname12 EconomySurname12,"
          + " age 12\n"
          + "18B -> Economy class passenger: EconomyFirstname13 EconomySurname13,"
          + " age 13\n"
          + "18C -> Economy class passenger: EconomyFirstname14 EconomySurname14,"
          + " age 14\n"
          + "18D -> Economy class passenger: EconomyFirstname15 EconomySurname15,"
          + " age 15\n"
          + "18E -> Economy class passenger: EconomyFirstname16 EconomySurname16,"
          + " age 16\n"
          + "18F -> Economy class passenger: EconomyFirstname17 EconomySurname17,"
          + " age 17\n"
          + "19A -> Economy class passenger: EconomyFirstname18 EconomySurname18,"
          + " age 18\n"
          + "19B -> Economy class passenger: EconomyFirstname19 EconomySurname19,"
          + " age 19\n"
          + "19C -> Economy class passenger: EconomyFirstname20 EconomySurname20,"
          + " age 20\n"
          + "19D -> Economy class passenger: EconomyFirstname21 EconomySurname21,"
          + " age 21\n"
          + "19E -> Economy class passenger: EconomyFirstname22 EconomySurname22,"
          + " age 22\n"
          + "19F -> Economy class passenger: EconomyFirstname23 EconomySurname23,"
          + " age 23\n"
          + "20A -> Economy class passenger: EconomyFirstname24 EconomySurname24,"
          + " age 24\n"
          + "20B -> Economy class passenger: EconomyFirstname25 EconomySurname25,"
          + " age 25\n"
          + "20C -> Economy class passenger: EconomyFirstname26 EconomySurname26,"
          + " age 26\n"
          + "20D -> Economy class passenger: EconomyFirstname27 EconomySurname27,"
          + " age 27\n"
          + "20E -> Economy class passenger: EconomyFirstname28 EconomySurname28,"
          + " age 28\n"
          + "20F -> Economy class passenger: EconomyFirstname29 EconomySurname29,"
          + " age 29\n"
          + "21A -> Economy class passenger: EconomyFirstname30 EconomySurname30,"
          + " age 30\n"
          + "21B -> Economy class passenger: EconomyFirstname31 EconomySurname31,"
          + " age 31\n"
          + "21C -> Economy class passenger: EconomyFirstname32 EconomySurname32,"
          + " age 32\n"
          + "21D -> Economy class passenger: EconomyFirstname33 EconomySurname33,"
          + " age 33\n"
          + "21E -> Economy class passenger: EconomyFirstname34 EconomySurname34,"
          + " age 34\n"
          + "21F -> Economy class passenger: EconomyFirstname35 EconomySurname35,"
          + " age 35\n"
          + "22A -> Economy class passenger: EconomyFirstname36 EconomySurname36,"
          + " age 36\n"
          + "22B -> Economy class passenger: EconomyFirstname37 EconomySurname37,"
          + " age 37\n"
          + "22C -> Economy class passenger: EconomyFirstname38 EconomySurname38,"
          + " age 38\n"
          + "22D -> Economy class passenger: EconomyFirstname39 EconomySurname39,"
          + " age 39\n"
          + "22E -> Economy class passenger: EconomyFirstname40 EconomySurname40,"
          + " age 40\n"
          + "22F -> Economy class passenger: EconomyFirstname41 EconomySurname41,"
          + " age 41\n"
          + "23A -> Economy class passenger: EconomyFirstname42 EconomySurname42,"
          + " age 42\n"
          + "23B -> Economy class passenger: EconomyFirstname43 EconomySurname43,"
          + " age 43\n"
          + "23C -> Economy class passenger: EconomyFirstname44 EconomySurname44,"
          + " age 44\n"
          + "23D -> Economy class passenger: EconomyFirstname45 EconomySurname45,"
          + " age 45\n"
          + "23E -> Economy class passenger: EconomyFirstname46 EconomySurname46,"
          + " age 46\n"
          + "23F -> Economy class passenger: EconomyFirstname47 EconomySurname47,"
          + " age 47\n"
          + "24A -> Economy class passenger: EconomyFirstname48 EconomySurname48,"
          + " age 48\n"
          + "24B -> Economy class passenger: EconomyFirstname49 EconomySurname49,"
          + " age 49\n"
          + "24C -> Economy class passenger: EconomyFirstname50 EconomySurname50,"
          + " age 50\n"
          + "24D -> Economy class passenger: EconomyFirstname51 EconomySurname51,"
          + " age 51\n"
          + "24E -> Economy class passenger: EconomyFirstname52 EconomySurname52,"
          + " age 52\n"
          + "24F -> Economy class passenger: EconomyFirstname53 EconomySurname53,"
          + " age 53\n"
          + "25A -> Economy class passenger: EconomyFirstname54 EconomySurname54,"
          + " age 54\n"
          + "25B -> Economy class passenger: EconomyFirstname55 EconomySurname55,"
          + " age 55\n"
          + "25C -> Economy class passenger: EconomyFirstname56 EconomySurname56,"
          + " age 56\n"
          + "25D -> Economy class passenger: EconomyFirstname57 EconomySurname57,"
          + " age 57\n"
          + "25E -> Economy class passenger: EconomyFirstname58 EconomySurname58,"
          + " age 58\n"
          + "25F -> Economy class passenger: EconomyFirstname59 EconomySurname59,"
          + " age 59\n"
          + "26A -> Economy class passenger: EconomyFirstname60 EconomySurname60,"
          + " age 60\n"
          + "26B -> Economy class passenger: EconomyFirstname61 EconomySurname61,"
          + " age 61\n"
          + "26C -> Economy class passenger: EconomyFirstname62 EconomySurname62,"
          + " age 62\n"
          + "26D -> Economy class passenger: EconomyFirstname63 EconomySurname63,"
          + " age 63\n"
          + "26E -> Economy class passenger: EconomyFirstname64 EconomySurname64,"
          + " age 64\n"
          + "26F -> Economy class passenger: EconomyFirstname65 EconomySurname65,"
          + " age 65\n"
          + "27A -> Economy class passenger: EconomyFirstname66 EconomySurname66,"
          + " age 66\n"
          + "27B -> Economy class passenger: EconomyFirstname67 EconomySurname67,"
          + " age 67\n"
          + "27C -> Economy class passenger: EconomyFirstname68 EconomySurname68,"
          + " age 68\n"
          + "27D -> Economy class passenger: EconomyFirstname69 EconomySurname69,"
          + " age 69\n"
          + "27E -> Economy class passenger: EconomyFirstname70 EconomySurname70,"
          + " age 70\n"
          + "27F -> Economy class passenger: EconomyFirstname71 EconomySurname71,"
          + " age 71\n"
          + "28A -> Economy class passenger: EconomyFirstname72 EconomySurname72,"
          + " age 72\n"
          + "28B -> Economy class passenger: EconomyFirstname73 EconomySurname73,"
          + " age 73\n"
          + "28C -> Economy class passenger: EconomyFirstname74 EconomySurname74,"
          + " age 74\n"
          + "28D -> Economy class passenger: EconomyFirstname75 EconomySurname75,"
          + " age 75\n"
          + "28E -> Economy class passenger: EconomyFirstname76 EconomySurname76,"
          + " age 76\n"
          + "28F -> Economy class passenger: EconomyFirstname77 EconomySurname77,"
          + " age 77\n"
          + "29A -> Economy class passenger: EconomyFirstname78 EconomySurname78,"
          + " age 78\n"
          + "29B -> Economy class passenger: EconomyFirstname79 EconomySurname79,"
          + " age 79\n"
          + "29C -> Economy class passenger: EconomyFirstname80 EconomySurname80,"
          + " age 80\n"
          + "29D -> Economy class passenger: EconomyFirstname81 EconomySurname81,"
          + " age 81\n"
          + "29E -> Economy class passenger: EconomyFirstname82 EconomySurname82,"
          + " age 82\n"
          + "29F -> Economy class passenger: EconomyFirstname83 EconomySurname83,"
          + " age 83\n"
          + "30A -> Economy class passenger: EconomyFirstname84 EconomySurname84,"
          + " age 84\n"
          + "30B -> Economy class passenger: EconomyFirstname85 EconomySurname85,"
          + " age 85\n"
          + "30C -> Economy class passenger: EconomyFirstname86 EconomySurname86,"
          + " age 86\n"
          + "30D -> Economy class passenger: EconomyFirstname87 EconomySurname87,"
          + " age 87\n"
          + "30E -> Economy class passenger: EconomyFirstname88 EconomySurname88,"
          + " age 88\n"
          + "30F -> Economy class passenger: EconomyFirstname89 EconomySurname89,"
          + " age 89\n"
          + "31A -> Economy class passenger: EconomyFirstname90 EconomySurname90,"
          + " age 90\n"
          + "31B -> Economy class passenger: EconomyFirstname91 EconomySurname91,"
          + " age 91\n"
          + "31C -> Economy class passenger: EconomyFirstname92 EconomySurname92,"
          + " age 92\n"
          + "31D -> Economy class passenger: EconomyFirstname93 EconomySurname93,"
          + " age 93\n"
          + "31E -> Economy class passenger: EconomyFirstname94 EconomySurname94,"
          + " age 94\n"
          + "31F -> Economy class passenger: EconomyFirstname95 EconomySurname95,"
          + " age 95\n"
          + "32A -> Economy class passenger: EconomyFirstname96 EconomySurname96,"
          + " age 96\n"
          + "32B -> Economy class passenger: EconomyFirstname97 EconomySurname97,"
          + " age 97\n"
          + "32C -> Economy class passenger: EconomyFirstname98 EconomySurname98,"
          + " age 98\n"
          + "32D -> Economy class passenger: EconomyFirstname99 EconomySurname99,"
          + " age 99\n"
          + "32E -> Economy class passenger: EconomyFirstname100 EconomySurname100,"
          + " age 0\n"
          + "32F -> Economy class passenger: EconomyFirstname101 EconomySurname101,"
          + " age 1\n"
          + "33A -> Economy class passenger: EconomyFirstname102 EconomySurname102,"
          + " age 2\n"
          + "33B -> Economy class passenger: EconomyFirstname103 EconomySurname103,"
          + " age 3\n"
          + "33C -> Economy class passenger: EconomyFirstname104 EconomySurname104,"
          + " age 4\n"
          + "33D -> Economy class passenger: EconomyFirstname105 EconomySurname105,"
          + " age 5\n"
          + "33E -> Economy class passenger: EconomyFirstname106 EconomySurname106,"
          + " age 6\n"
          + "33F -> Economy class passenger: EconomyFirstname107 EconomySurname107,"
          + " age 7\n"
          + "34A -> Economy class passenger: EconomyFirstname108 EconomySurname108,"
          + " age 8\n"
          + "34B -> Economy class passenger: EconomyFirstname109 EconomySurname109,"
          + " age 9\n"
          + "34C -> Economy class passenger: EconomyFirstname110 EconomySurname110,"
          + " age 10\n"
          + "34D -> Economy class passenger: EconomyFirstname111 EconomySurname111,"
          + " age 11\n"
          + "34E -> Economy class passenger: EconomyFirstname112 EconomySurname112,"
          + " age 12\n"
          + "34F -> Economy class passenger: EconomyFirstname113 EconomySurname113,"
          + " age 13\n"
          + "35A -> Economy class passenger: EconomyFirstname114 EconomySurname114,"
          + " age 14\n"
          + "35B -> Economy class passenger: EconomyFirstname115 EconomySurname115,"
          + " age 15\n"
          + "35C -> Economy class passenger: EconomyFirstname116 EconomySurname116,"
          + " age 16\n"
          + "35D -> Economy class passenger: EconomyFirstname117 EconomySurname117,"
          + " age 17\n"
          + "35E -> Economy class passenger: EconomyFirstname118 EconomySurname118,"
          + " age 18\n"
          + "35F -> Economy class passenger: EconomyFirstname119 EconomySurname119,"
          + " age 19\n"
          + "36A -> Economy class passenger: EconomyFirstname120 EconomySurname120,"
          + " age 20\n"
          + "36B -> Economy class passenger: EconomyFirstname121 EconomySurname121,"
          + " age 21\n"
          + "36C -> Economy class passenger: EconomyFirstname122 EconomySurname122,"
          + " age 22\n"
          + "36D -> Economy class passenger: EconomyFirstname123 EconomySurname123,"
          + " age 23\n"
          + "36E -> Economy class passenger: EconomyFirstname124 EconomySurname124,"
          + " age 24\n"
          + "36F -> Economy class passenger: EconomyFirstname125 EconomySurname125,"
          + " age 25\n"
          + "37A -> Economy class passenger: EconomyFirstname126 EconomySurname126,"
          + " age 26\n"
          + "37B -> Economy class passenger: EconomyFirstname127 EconomySurname127,"
          + " age 27\n"
          + "37C -> Economy class passenger: EconomyFirstname128 EconomySurname128,"
          + " age 28\n"
          + "37D -> Economy class passenger: EconomyFirstname129 EconomySurname129,"
          + " age 29\n"
          + "37E -> Economy class passenger: EconomyFirstname130 EconomySurname130,"
          + " age 30\n"
          + "37F -> Economy class passenger: EconomyFirstname131 EconomySurname131,"
          + " age 31\n"
          + "38A -> Economy class passenger: EconomyFirstname132 EconomySurname132,"
          + " age 32\n"
          + "38B -> Economy class passenger: EconomyFirstname133 EconomySurname133,"
          + " age 33\n"
          + "38C -> Economy class passenger: EconomyFirstname134 EconomySurname134,"
          + " age 34\n"
          + "38D -> Economy class passenger: EconomyFirstname135 EconomySurname135,"
          + " age 35\n"
          + "38E -> Economy class passenger: EconomyFirstname136 EconomySurname136,"
          + " age 36\n"
          + "38F -> Economy class passenger: EconomyFirstname137 EconomySurname137,"
          + " age 37\n"
          + "39A -> Economy class passenger: EconomyFirstname138 EconomySurname138,"
          + " age 38\n"
          + "39B -> Economy class passenger: EconomyFirstname139 EconomySurname139,"
          + " age 39\n"
          + "39C -> Economy class passenger: EconomyFirstname140 EconomySurname140,"
          + " age 40\n"
          + "39D -> Economy class passenger: EconomyFirstname141 EconomySurname141,"
          + " age 41\n"
          + "39E -> Economy class passenger: EconomyFirstname142 EconomySurname142,"
          + " age 42\n"
          + "39F -> Economy class passenger: EconomyFirstname143 EconomySurname143,"
          + " age 43\n"
          + "40A -> Economy class passenger: EconomyFirstname144 EconomySurname144,"
          + " age 44\n"
          + "40B -> Economy class passenger: EconomyFirstname145 EconomySurname145,"
          + " age 45\n"
          + "40C -> Economy class passenger: EconomyFirstname146 EconomySurname146,"
          + " age 46\n"
          + "40D -> Economy class passenger: EconomyFirstname147 EconomySurname147,"
          + " age 47\n"
          + "40E -> Economy class passenger: EconomyFirstname148 EconomySurname148,"
          + " age 48\n"
          + "40F -> Economy class passenger: EconomyFirstname149 EconomySurname149,"
          + " age 49\n"
          + "41A -> Economy class passenger: EconomyFirstname150 EconomySurname150,"
          + " age 50\n"
          + "41B -> Economy class passenger: EconomyFirstname151 EconomySurname151,"
          + " age 51\n"
          + "41C -> Economy class passenger: EconomyFirstname152 EconomySurname152,"
          + " age 52\n"
          + "41D -> Economy class passenger: EconomyFirstname153 EconomySurname153,"
          + " age 53\n"
          + "41E -> Economy class passenger: EconomyFirstname154 EconomySurname154,"
          + " age 54\n"
          + "41F -> Economy class passenger: EconomyFirstname155 EconomySurname155,"
          + " age 55\n"
          + "42A -> Economy class passenger: EconomyFirstname156 EconomySurname156,"
          + " age 56\n"
          + "42B -> Economy class passenger: EconomyFirstname157 EconomySurname157,"
          + " age 57\n"
          + "42C -> Economy class passenger: EconomyFirstname158 EconomySurname158,"
          + " age 58\n"
          + "42D -> Economy class passenger: EconomyFirstname159 EconomySurname159,"
          + " age 59\n"
          + "42E -> Economy class passenger: EconomyFirstname160 EconomySurname160,"
          + " age 60\n"
          + "42F -> Economy class passenger: EconomyFirstname161 EconomySurname161,"
          + " age 61\n"
          + "43A -> Economy class passenger: EconomyFirstname162 EconomySurname162,"
          + " age 62\n"
          + "43B -> Economy class passenger: EconomyFirstname163 EconomySurname163,"
          + " age 63\n"
          + "43C -> Economy class passenger: EconomyFirstname164 EconomySurname164,"
          + " age 64\n"
          + "43D -> Economy class passenger: EconomyFirstname165 EconomySurname165,"
          + " age 65\n"
          + "43E -> Economy class passenger: EconomyFirstname166 EconomySurname166,"
          + " age 66\n"
          + "43F -> Economy class passenger: EconomyFirstname167 EconomySurname167,"
          + " age 67\n"
          + "44A -> Economy class passenger: EconomyFirstname168 EconomySurname168,"
          + " age 68\n"
          + "44B -> Economy class passenger: EconomyFirstname169 EconomySurname169,"
          + " age 69\n"
          + "44C -> Economy class passenger: EconomyFirstname170 EconomySurname170,"
          + " age 70\n"
          + "44D -> Economy class passenger: EconomyFirstname171 EconomySurname171,"
          + " age 71\n"
          + "44E -> Economy class passenger: EconomyFirstname172 EconomySurname172,"
          + " age 72\n"
          + "44F -> Economy class passenger: EconomyFirstname173 EconomySurname173,"
          + " age 73\n"
          + "45A -> Economy class passenger: EconomyFirstname174 EconomySurname174,"
          + " age 74\n"
          + "45B -> Economy class passenger: EconomyFirstname175 EconomySurname175,"
          + " age 75\n"
          + "45C -> Economy class passenger: EconomyFirstname176 EconomySurname176,"
          + " age 76\n"
          + "45D -> Economy class passenger: EconomyFirstname177 EconomySurname177,"
          + " age 77\n"
          + "45E -> Economy class passenger: EconomyFirstname178 EconomySurname178,"
          + " age 78\n"
          + "45F -> Economy class passenger: EconomyFirstname179 EconomySurname179,"
          + " age 79\n"
          + "46A -> Economy class passenger: EconomyFirstname180 EconomySurname180,"
          + " age 80\n"
          + "46B -> Economy class passenger: EconomyFirstname181 EconomySurname181,"
          + " age 81\n"
          + "46C -> Economy class passenger: EconomyFirstname182 EconomySurname182,"
          + " age 82\n"
          + "46D -> Economy class passenger: EconomyFirstname183 EconomySurname183,"
          + " age 83\n"
          + "46E -> Economy class passenger: EconomyFirstname184 EconomySurname184,"
          + " age 84\n"
          + "46F -> Economy class passenger: EconomyFirstname185 EconomySurname185,"
          + " age 85\n"
          + "47A -> Economy class passenger: EconomyFirstname186 EconomySurname186,"
          + " age 86\n"
          + "47B -> Economy class passenger: EconomyFirstname187 EconomySurname187,"
          + " age 87\n"
          + "47C -> Economy class passenger: EconomyFirstname188 EconomySurname188,"
          + " age 88\n"
          + "47D -> Economy class passenger: EconomyFirstname189 EconomySurname189,"
          + " age 89\n"
          + "47E -> Economy class passenger: EconomyFirstname190 EconomySurname190,"
          + " age 90\n"
          + "47F -> Economy class passenger: EconomyFirstname191 EconomySurname191,"
          + " age 91\n"
          + "48A -> Economy class passenger: EconomyFirstname192 EconomySurname192,"
          + " age 92\n"
          + "48B -> Economy class passenger: EconomyFirstname193 EconomySurname193,"
          + " age 93\n"
          + "48C -> Economy class passenger: EconomyFirstname194 EconomySurname194,"
          + " age 94\n"
          + "48D -> Economy class passenger: EconomyFirstname195 EconomySurname195,"
          + " age 95\n"
          + "48E -> Economy class passenger: EconomyFirstname196 EconomySurname196,"
          + " age 96\n"
          + "48F -> Economy class passenger: EconomyFirstname197 EconomySurname197,"
          + " age 97\n"
          + "49A -> Economy class passenger: EconomyFirstname198 EconomySurname198,"
          + " age 98\n"
          + "49B -> Economy class passenger: EconomyFirstname199 EconomySurname199,"
          + " age 99\n";

  private static final String EXPECTED_RESULT_3 =
      EXPECTED_RESULT_2
          + "49C -> Economy class passenger: MoreEconomyFirstname0 MoreEconomySurname0,"
          + " age 0\n"
          + "49D -> Economy class passenger: MoreEconomyFirstname1 MoreEconomySurname1,"
          + " age 1\n"
          + "49E -> Economy class passenger: MoreEconomyFirstname2 MoreEconomySurname2,"
          + " age 2\n"
          + "49F -> Economy class passenger: MoreEconomyFirstname3 MoreEconomySurname3,"
          + " age 3\n"
          + "50A -> Economy class passenger: MoreEconomyFirstname4 MoreEconomySurname4,"
          + " age 4\n"
          + "50B -> Economy class passenger: MoreEconomyFirstname5 MoreEconomySurname5,"
          + " age 5\n"
          + "50C -> Economy class passenger: MoreEconomyFirstname6 MoreEconomySurname6,"
          + " age 6\n"
          + "50D -> Economy class passenger: MoreEconomyFirstname7 MoreEconomySurname7,"
          + " age 7\n"
          + "50E -> Economy class passenger: MoreEconomyFirstname8 MoreEconomySurname8,"
          + " age 8\n"
          + "50F -> Economy class passenger: MoreEconomyFirstname9 MoreEconomySurname9,"
          + " age 9\n";

  private String getPassengers1() {
    final StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < 6; i++) {
      stringBuilder
          .append("crew\nCrewFirstname")
          .append(i)
          .append("\nCrewSurname")
          .append(i)
          .append("\n");
    }
    for (int i = 0; i < 48; i++) {
      stringBuilder
          .append("business\nBusinessFirstname")
          .append(i)
          .append("\nBusinessSurname")
          .append(i)
          .append("\n")
          .append(i + 18)
          .append("\nTRUFFLES\n");
    }
    for (int i = 0; i < 30; i++) {
      stringBuilder
          .append("business\nChildBusinessFirstname")
          .append(i)
          .append("\nChildBusinessSurname")
          .append(i)
          .append("\n")
          .append(i % 18)
          .append("\nSTRAWBERRIES\n");
    }
    return stringBuilder.toString();
  }

  private String getPassengers2() {
    final StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < 6; i++) {
      stringBuilder
          .append("crew\nCrewFirstname")
          .append(i)
          .append("\nCrewSurname")
          .append(i)
          .append("\n");
    }
    for (int i = 0; i < 48; i++) {
      stringBuilder
          .append("business\nBusinessFirstname")
          .append(i)
          .append("\nBusinessSurname")
          .append(i)
          .append("\n")
          .append(i + 18)
          .append("\nTRUFFLES\n");
    }
    for (int i = 0; i < 31; i++) {
      stringBuilder
          .append("business\nChildBusinessFirstname")
          .append(i)
          .append("\nChildBusinessSurname")
          .append(i)
          .append("\n")
          .append(i % 18)
          .append("\nSTRAWBERRIES\n");
    }
    return stringBuilder.toString();
  }

  private String getPassengers3() {
    final StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < 200; i++) {
      stringBuilder
          .append("economy\nEconomyFirstname")
          .append(i)
          .append("\nEconomySurname")
          .append(i)
          .append("\n")
          .append(i % 100)
          .append("\n");
    }
    return stringBuilder.toString();
  }

  private String getPassengers4() {
    final StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < 200; i++) {
      stringBuilder
          .append("economy\nMoreEconomyFirstname")
          .append(i)
          .append("\nMoreEconomySurname")
          .append(i)
          .append("\n")
          .append(i % 100)
          .append("\n");
    }
    return stringBuilder.toString();
  }

  @Rule public TemporaryFolder temporaryFolder = new TemporaryFolder();

  @Test
  public void testSuccessfulAllocation1() throws Exception {
    final File file = temporaryFolder.newFile();
    final FileWriter fw = new FileWriter(file);
    fw.write(getPassengers1());
    fw.close();
    final SeatAllocator seatAllocator = new SeatAllocator();
    try {
      seatAllocator.allocate(file.getAbsolutePath());
    } catch (AllocationNotPossibleException exception) {
      fail("An allocation should have been possible");
    }
    assertEquals(EXPECTED_RESULT_1, seatAllocator.toString());
  }

  @Test
  public void testUnsuccessfulAllocation1() throws Exception {
    final File file = temporaryFolder.newFile();
    final FileWriter fw = new FileWriter(file);
    fw.write(getPassengers2());
    fw.close();
    final SeatAllocator seatAllocator = new SeatAllocator();
    try {
      seatAllocator.allocate(file.getAbsolutePath());
      fail("An exception should have occurred");
    } catch (AllocationNotPossibleException exception) {
      // Good: this exception is expected.
    }
    assertEquals(EXPECTED_RESULT_1, seatAllocator.toString());
  }

  @Test
  public void testUltimatelyUnsuccessfulAllocation() throws Exception {
    final File file1 = temporaryFolder.newFile();
    final FileWriter fw1 = new FileWriter(file1);
    fw1.write(getPassengers3());
    fw1.close();
    final File file2 = temporaryFolder.newFile();
    final FileWriter fw2 = new FileWriter(file2);
    fw2.write(getPassengers4());
    fw2.close();
    final SeatAllocator seatAllocator = new SeatAllocator();
    try {
      seatAllocator.allocate(file1.getAbsolutePath());
    } catch (AllocationNotPossibleException exception) {
      fail("An allocation should have been possible");
    }
    assertEquals(EXPECTED_RESULT_2, seatAllocator.toString());
    try {
      seatAllocator.allocate(file2.getAbsolutePath());
      fail("An exception should have occurred");
    } catch (AllocationNotPossibleException exception) {
      // Good: this exception is expected.
    }
    assertEquals(EXPECTED_RESULT_3, seatAllocator.toString());
  }
   */
}
