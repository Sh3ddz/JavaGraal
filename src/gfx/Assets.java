package gfx;

import java.awt.image.BufferedImage;

public class Assets
{
	
	private static final int WIDTH = 16, HEIGHT = 16;
	
	//IMAGES
	public static BufferedImage playerHead, playerBody, displacedWaterParticle, grassParticle, air, grass, grass2, flower, grass3, grass4, entrancePadL, entrancePadR, path, path2, path3, path4, smallRock, mushroom, snow, snow2,
								dirt, dirt2, dirt3, dirt4, dirt5,																        spawnPad1, spawnPad2, stonepath1, stonepath2, path5, mushroomGroup1, mushroomGroup2, mushroomGroup3, mushroomGroup4,
								water, water2, waterRock,																				spawnPad3, spawnPad4, stonepath3, stonepath4,
								bush1, bush2, rock1, rock2, struc1, struc2, tallgrass1, tallgrass2, sign1, sign2, tallgrassend1, tallgrassend2, fencetop, fenceconnecttop,							bench1, bench2, bench3, chair1, chair2,
								bush3, bush4, rock3, rock4, struc3, struc4, tallgrass3, tallgrass4, sign3, sign4, tallgrassend3, tallgrassend4, fencebottom, fenceconnectshadow, fenceconnectdown,  bench4, bench5, bench6, chair3, chair4,
								       tree1, tree2, tree3, tree4, tree5, tree6,					stump1, stump2, stump3, stump4,
								tree7, tree8, tree9, tree10, tree11, tree12, tree13, tree14,		stump5, stump6, stump7, stump8,
								tree15, tree16, tree17, tree18, tree19, tree20, tree21, tree22,    	stump9, stump10, stump11, stump12,
								tree23, tree24, tree25, tree26, tree27, tree28, tree29, tree30,		stump13, stump14, stump15, stump16,
								tree31, tree32, tree33, tree34, tree35, tree36, tree37, tree38,     stumpTree1, stumpTree2, stumpTree3, stumpTree4,
								tree39, tree40, tree41, tree42, tree43, tree44, tree45, tree46,		stumpTree5, stumpTree6, stumpTree7, stumpTree8,
								tree47, tree48, tree49, tree50, tree51, tree52, tree53, tree54,		stumpTree9, stumpTree10, stumpTree11, stumpTree12,
								tree55, tree56, tree57, tree58, tree59, tree60, tree61, tree62,		stumpTree13, stumpTree14, stumpTree15, stumpTree16,
									   tree63, tree64, tree65, tree66, tree67, tree68,				table1, table2, table3, table4,
									   		   tree69, tree70, tree71, tree72,						table5, table6, table7, table8, 
							    house1, house2, house3, house4, house5, house6, house7, house8,		table9, table10, table11, table12,
							    house9, house10, house11, house12, house13, house14, house15, house16,
							    house17, house18, house19, house20, house21, house22, house23, house24,
							    house25, house26, house27, house28, house29, house30, house31, house32,
							    house33, house34, house35, house36, house37, house38, house39, house40,
							    house41, house42, house43, house44, house45, house46, house47, house48,
							    house49, house50, house51, house52, house53, house54, house55, houseShadow1, houseShadow2, houseShadow3,
								selector, muteSound, nextSong,
								hedge1, hedge2, hedge3, hedge4, hedge5, hedge6, hedge7, hedge8, 
								hedge9, hedge10, hedge11,
								cliff1, cliff2, cliff3, cliff4, cliff5, cliff6, cliff7, cliff8, cliff9, cliff10,
								cliff11, cliff12, cliff13, cliff14, cliff15, cliff16, cliff17, cliff18, cliff19, cliff20,
								cliff21, cliff22, cliff23, cliff24, cliff25, cliff26, cliff27, cliff28, cliff29, cliff30,
								cliff31, cliff32, cliff33, cliff34, cliff35, cliff36, cliff37, cliff38, cliff39, cliff40,
								cliff41, cliff42, cliff43, cliff44, cliff45, cliff46, cliff47, cliff48, cliff49, cliff50,
								cliff51, cliff52, cliff53, cliff54, cliff55, cliff56, cliff57, cliff58, cliff59, cliff60,
								cliff61, cliff62, cliff63, cliff64, cliff65, cliff66, cliff67, cliff68,
								treeFull, stumpFull, stumpTreeFull, bushFull, rockFull, strucFull, tallgrassFull, signFull, fenceFull, mushroomGroupFull;
	//animations
	public static BufferedImage[] playerHeadDirections, playerStanding, playerSwordUp, playerSwordDown, playerSwordLeft, playerSwordRight, playerAttackingUp, playerAttackingDown, playerAttackingLeft, playerAttackingRight, playerWalkingUp, playerWalkingDown, playerWalkingLeft, playerWalkingRight,grassParticleAnimations,
								  baddyHeadDirections, baddyStanding, baddyWalkingUp, baddyWalkingDown, baddyWalkingLeft, baddyWalkingRight;
	//other
	public static BufferedImage loadingScreen = ImageLoader.loadImage("/resources/textures/loading.png");
	
	//FOR Graal Online Classic tiles:
	public static SpriteSheet tileSheet = new SpriteSheet(ImageLoader.loadImage("/resources/textures/tileSpriteSheet.png"));
	//FOR A Link To The Past tiles:
	//public static SpriteSheet tileSheet = new SpriteSheet(ImageLoader.loadImage("/resources/textures/ALTTPSpriteSheet.png"));
	public static SpriteSheet entitySheet = new SpriteSheet(ImageLoader.loadImage("/resources/textures/entitySpriteSheet.png"));

	public static void init()
	{		
		initAnimations();
		playerHead = entitySheet.crop(WIDTH*2, HEIGHT*28, WIDTH*2, HEIGHT*2);
		playerBody = entitySheet.crop(WIDTH*2, HEIGHT*30, WIDTH*2, HEIGHT*2);
		displacedWaterParticle = tileSheet.crop(WIDTH*29, HEIGHT*31, WIDTH*2, HEIGHT);
		grassParticle = tileSheet.crop(WIDTH*27, HEIGHT*31, WIDTH*2, HEIGHT);

		muteSound = tileSheet.crop(WIDTH, HEIGHT*27, WIDTH, HEIGHT);
		nextSong = tileSheet.crop(WIDTH*2, HEIGHT*27, WIDTH, HEIGHT);
		
		air = tileSheet.crop(WIDTH*31, HEIGHT*31, WIDTH, HEIGHT);
		grass = tileSheet.crop(0, 0, WIDTH, HEIGHT);
		grass2 = tileSheet.crop(WIDTH, 0, WIDTH, HEIGHT);
	    flower = tileSheet.crop(WIDTH*2, 0, WIDTH, HEIGHT);
	    grass3 = tileSheet.crop(WIDTH*3, 0, WIDTH, HEIGHT);
	    grass4 = tileSheet.crop(WIDTH*4, 0, WIDTH, HEIGHT);
	    entrancePadL = tileSheet.crop(WIDTH*5, 0, WIDTH, HEIGHT);
	    entrancePadR = tileSheet.crop(WIDTH*6, 0, WIDTH, HEIGHT);
	    path = tileSheet.crop(WIDTH*7, 0, WIDTH, HEIGHT);
	    path2 = tileSheet.crop(WIDTH*8, 0, WIDTH, HEIGHT);
	    path3 = tileSheet.crop(WIDTH*9, 0, WIDTH, HEIGHT);
	    path4 = tileSheet.crop(WIDTH*10, 0, WIDTH, HEIGHT);
	    path5 = tileSheet.crop(WIDTH*10, HEIGHT, WIDTH, HEIGHT);
	    dirt = tileSheet.crop(0, HEIGHT, WIDTH, HEIGHT);
	    dirt2 = tileSheet.crop(WIDTH, HEIGHT, WIDTH, HEIGHT);
	    dirt3 = tileSheet.crop(WIDTH*2, HEIGHT, WIDTH, HEIGHT);
	    dirt4 = tileSheet.crop(WIDTH*3, HEIGHT, WIDTH, HEIGHT);
	    dirt5 = tileSheet.crop(WIDTH*4, HEIGHT, WIDTH, HEIGHT);
	    water = tileSheet.crop(0, HEIGHT*2, WIDTH, HEIGHT);
	    water2 = tileSheet.crop(WIDTH, HEIGHT*2, WIDTH, HEIGHT);
	    waterRock = tileSheet.crop(WIDTH*2, HEIGHT*2, WIDTH, HEIGHT);
	    snow = tileSheet.crop(WIDTH*15, 0, WIDTH, HEIGHT);
	    snow2 = tileSheet.crop(WIDTH*16, 0, WIDTH, HEIGHT);
	    fencetop = tileSheet.crop(WIDTH*12, HEIGHT*3, WIDTH, HEIGHT);
	    fencebottom = tileSheet.crop(WIDTH*12, HEIGHT*4, WIDTH, HEIGHT);
	    fenceconnecttop = tileSheet.crop(WIDTH*13, HEIGHT*3, WIDTH, HEIGHT);
	    fenceconnectshadow = tileSheet.crop(WIDTH*13, HEIGHT*4, WIDTH, HEIGHT);
	    fenceconnectdown = tileSheet.crop(WIDTH*14, HEIGHT*4, WIDTH, HEIGHT);
	    smallRock = tileSheet.crop(WIDTH*11, 0, WIDTH, HEIGHT);
	    mushroom = tileSheet.crop(WIDTH*12, 0, WIDTH, HEIGHT);
	    
	    //2x2 tiles
	    bush1 = tileSheet.crop(0, HEIGHT*3, WIDTH, HEIGHT);
	    bush2 = tileSheet.crop(WIDTH, HEIGHT*3, WIDTH, HEIGHT);
	    bush3 = tileSheet.crop(0, HEIGHT*4, WIDTH, HEIGHT);
	    bush4 = tileSheet.crop(WIDTH, HEIGHT*4, WIDTH, HEIGHT);
	    rock1 = tileSheet.crop(WIDTH*2, HEIGHT*3, WIDTH, HEIGHT);
	    rock2 = tileSheet.crop(WIDTH*3, HEIGHT*3, WIDTH, HEIGHT);
	    rock3 = tileSheet.crop(WIDTH*2, HEIGHT*4, WIDTH, HEIGHT);
	    rock4 = tileSheet.crop(WIDTH*3, HEIGHT*4, WIDTH, HEIGHT);
	    struc1 = tileSheet.crop(WIDTH*4, HEIGHT*3, WIDTH, HEIGHT);
	    struc2 = tileSheet.crop(WIDTH*5, HEIGHT*3, WIDTH, HEIGHT);
	    struc3 = tileSheet.crop(WIDTH*4, HEIGHT*4, WIDTH, HEIGHT);
	    struc4 = tileSheet.crop(WIDTH*5, HEIGHT*4, WIDTH, HEIGHT);
	    tallgrass1 = tileSheet.crop(WIDTH*6, HEIGHT*3, WIDTH, HEIGHT);
	    tallgrass2 = tileSheet.crop(WIDTH*7, HEIGHT*3, WIDTH, HEIGHT);
	    tallgrass3 = tileSheet.crop(WIDTH*6, HEIGHT*4, WIDTH, HEIGHT);
	    tallgrass4 = tileSheet.crop(WIDTH*7, HEIGHT*4, WIDTH, HEIGHT);
	    sign1 = tileSheet.crop(WIDTH*8, HEIGHT*3, WIDTH, HEIGHT);
	    sign2 = tileSheet.crop(WIDTH*9, HEIGHT*3, WIDTH, HEIGHT);
	    sign3 = tileSheet.crop(WIDTH*8, HEIGHT*4, WIDTH, HEIGHT);
	    sign4 = tileSheet.crop(WIDTH*9, HEIGHT*4, WIDTH, HEIGHT);
	    tallgrassend1 = tileSheet.crop(WIDTH*10, HEIGHT*3, WIDTH, HEIGHT);
	    tallgrassend2 = tileSheet.crop(WIDTH*11, HEIGHT*3, WIDTH, HEIGHT);
	    tallgrassend3 = tileSheet.crop(WIDTH*10, HEIGHT*4, WIDTH, HEIGHT);
	    tallgrassend4 = tileSheet.crop(WIDTH*11, HEIGHT*4, WIDTH, HEIGHT);
	    stonepath1 = tileSheet.crop(WIDTH*8, HEIGHT, WIDTH, HEIGHT);
	    stonepath2 = tileSheet.crop(WIDTH*9, HEIGHT, WIDTH, HEIGHT);
	    stonepath3 = tileSheet.crop(WIDTH*8, HEIGHT*2, WIDTH, HEIGHT);
	    stonepath4 = tileSheet.crop(WIDTH*9, HEIGHT*2, WIDTH, HEIGHT);
	    spawnPad1 = tileSheet.crop(WIDTH*6, HEIGHT, WIDTH, HEIGHT);
	    spawnPad2 = tileSheet.crop(WIDTH*7, HEIGHT, WIDTH, HEIGHT);
	    spawnPad3 = tileSheet.crop(WIDTH*6, HEIGHT*2, WIDTH, HEIGHT);
	    spawnPad4 = tileSheet.crop(WIDTH*7, HEIGHT*2, WIDTH, HEIGHT);
	    mushroomGroup1 = tileSheet.crop(WIDTH*11, WIDTH, WIDTH, HEIGHT);
	    mushroomGroup2 = tileSheet.crop(WIDTH*12, WIDTH, WIDTH, HEIGHT);
	    mushroomGroup3 = tileSheet.crop(WIDTH*11, WIDTH*2, WIDTH, HEIGHT);
	    mushroomGroup4 = tileSheet.crop(WIDTH*12, WIDTH*2, WIDTH, HEIGHT);
	    bench1 = tileSheet.crop(WIDTH*17, WIDTH*3, WIDTH, HEIGHT);
	    bench2 = tileSheet.crop(WIDTH*18, WIDTH*3, WIDTH, HEIGHT);
	    bench3 = tileSheet.crop(WIDTH*19, WIDTH*3, WIDTH, HEIGHT);
	    bench4 = tileSheet.crop(WIDTH*17, WIDTH*4, WIDTH, HEIGHT);
	    bench5 = tileSheet.crop(WIDTH*18, WIDTH*4, WIDTH, HEIGHT);
	    bench6 = tileSheet.crop(WIDTH*19, WIDTH*4, WIDTH, HEIGHT);
	    chair1 = tileSheet.crop(WIDTH*20, WIDTH*3, WIDTH, HEIGHT);
	    chair2 = tileSheet.crop(WIDTH*21, WIDTH*3, WIDTH, HEIGHT);
	    chair3 = tileSheet.crop(WIDTH*20, WIDTH*4, WIDTH, HEIGHT);
	    chair4 = tileSheet.crop(WIDTH*21, WIDTH*4, WIDTH, HEIGHT);
	    
	    //4x4 tiles
	    stump1 = tileSheet.crop(WIDTH*8, HEIGHT*5, WIDTH, HEIGHT);
	    stump2 = tileSheet.crop(WIDTH*9, HEIGHT*5, WIDTH, HEIGHT);
	    stump3 = tileSheet.crop(WIDTH*10, HEIGHT*5, WIDTH, HEIGHT);
	    stump4 = tileSheet.crop(WIDTH*11, HEIGHT*5, WIDTH, HEIGHT);
	    stump5 = tileSheet.crop(WIDTH*8, HEIGHT*6, WIDTH, HEIGHT);
	    stump6 = tileSheet.crop(WIDTH*9, HEIGHT*6, WIDTH, HEIGHT);
	    stump7 = tileSheet.crop(WIDTH*10, HEIGHT*6, WIDTH, HEIGHT);
	    stump8 = tileSheet.crop(WIDTH*11, HEIGHT*6, WIDTH, HEIGHT);
	    stump9 = tileSheet.crop(WIDTH*8, HEIGHT*7, WIDTH, HEIGHT);
	    stump10 = tileSheet.crop(WIDTH*9, HEIGHT*7, WIDTH, HEIGHT);
	    stump11 = tileSheet.crop(WIDTH*10, HEIGHT*7, WIDTH, HEIGHT);
	    stump12 = tileSheet.crop(WIDTH*11, HEIGHT*7, WIDTH, HEIGHT);
	    stump13 = tileSheet.crop(WIDTH*8, HEIGHT*8, WIDTH, HEIGHT);
	    stump14 = tileSheet.crop(WIDTH*9, HEIGHT*8, WIDTH, HEIGHT);
	    stump15 = tileSheet.crop(WIDTH*10, HEIGHT*8, WIDTH, HEIGHT);
	    stump16 = tileSheet.crop(WIDTH*11, HEIGHT*8, WIDTH, HEIGHT);
	    
	    stumpTree1 = tileSheet.crop(WIDTH*8, HEIGHT*9, WIDTH, HEIGHT);
	    stumpTree2 = tileSheet.crop(WIDTH*9, HEIGHT*9, WIDTH, HEIGHT);
	    stumpTree3 = tileSheet.crop(WIDTH*10, HEIGHT*9, WIDTH, HEIGHT);
	    stumpTree4 = tileSheet.crop(WIDTH*11, HEIGHT*9, WIDTH, HEIGHT);
	    stumpTree5 = tileSheet.crop(WIDTH*8, HEIGHT*10, WIDTH, HEIGHT);
	    stumpTree6 = tileSheet.crop(WIDTH*9, HEIGHT*10, WIDTH, HEIGHT);
	    stumpTree7 = tileSheet.crop(WIDTH*10, HEIGHT*10, WIDTH, HEIGHT);
	    stumpTree8 = tileSheet.crop(WIDTH*11, HEIGHT*10, WIDTH, HEIGHT);
	    stumpTree9 = tileSheet.crop(WIDTH*8, HEIGHT*11, WIDTH, HEIGHT);
	    stumpTree10 = tileSheet.crop(WIDTH*9, HEIGHT*11, WIDTH, HEIGHT);
	    stumpTree11 = tileSheet.crop(WIDTH*10, HEIGHT*11, WIDTH, HEIGHT);
	    stumpTree12 = tileSheet.crop(WIDTH*11, HEIGHT*11, WIDTH, HEIGHT);
	    stumpTree13 = tileSheet.crop(WIDTH*8, HEIGHT*12, WIDTH, HEIGHT);
	    stumpTree14 = tileSheet.crop(WIDTH*9, HEIGHT*12, WIDTH, HEIGHT);
	    stumpTree15 = tileSheet.crop(WIDTH*10, HEIGHT*12, WIDTH, HEIGHT);
	    stumpTree16 = tileSheet.crop(WIDTH*11, HEIGHT*12, WIDTH, HEIGHT);
	    
	    table1 = tileSheet.crop(WIDTH*8, HEIGHT*13, WIDTH, HEIGHT);
	    table2 = tileSheet.crop(WIDTH*9, HEIGHT*13, WIDTH, HEIGHT);
	    table3 = tileSheet.crop(WIDTH*10, HEIGHT*13, WIDTH, HEIGHT);
	    table4 = tileSheet.crop(WIDTH*11, HEIGHT*13, WIDTH, HEIGHT);
	    table5 = tileSheet.crop(WIDTH*8, HEIGHT*14, WIDTH, HEIGHT);
	    table6 = tileSheet.crop(WIDTH*9, HEIGHT*14, WIDTH, HEIGHT);
	    table7 = tileSheet.crop(WIDTH*10, HEIGHT*14, WIDTH, HEIGHT);
	    table8 = tileSheet.crop(WIDTH*11, HEIGHT*14, WIDTH, HEIGHT);
	    table9 = tileSheet.crop(WIDTH*8, HEIGHT*15, WIDTH, HEIGHT);
	    table10 = tileSheet.crop(WIDTH*9, HEIGHT*15, WIDTH, HEIGHT);
	    table11 = tileSheet.crop(WIDTH*10, HEIGHT*15, WIDTH, HEIGHT);
	    table12 = tileSheet.crop(WIDTH*11, HEIGHT*15, WIDTH, HEIGHT);
	    
	    //EVEN LARGER TILES...
	    //tree
	    tree1 = tileSheet.crop(WIDTH, HEIGHT*5, WIDTH, HEIGHT);
	    tree2 = tileSheet.crop(WIDTH*2, HEIGHT*5, WIDTH, HEIGHT);
	    tree3 = tileSheet.crop(WIDTH*3, HEIGHT*5, WIDTH, HEIGHT);
	    tree4 = tileSheet.crop(WIDTH*4, HEIGHT*5, WIDTH, HEIGHT);
	    tree5 = tileSheet.crop(WIDTH*5, HEIGHT*5, WIDTH, HEIGHT);
	    tree6 = tileSheet.crop(WIDTH*6, HEIGHT*5, WIDTH, HEIGHT);
	    tree7 = tileSheet.crop(0, HEIGHT*6, WIDTH, HEIGHT);
	    tree8 = tileSheet.crop(WIDTH, HEIGHT*6, WIDTH, HEIGHT);
	    tree9 = tileSheet.crop(WIDTH*2, HEIGHT*6, WIDTH, HEIGHT);
	    tree10 = tileSheet.crop(WIDTH*3, HEIGHT*6, WIDTH, HEIGHT);
	    tree11 = tileSheet.crop(WIDTH*4, HEIGHT*6, WIDTH, HEIGHT);
	    tree12 = tileSheet.crop(WIDTH*5, HEIGHT*6, WIDTH, HEIGHT);
	    tree13 = tileSheet.crop(WIDTH*6, HEIGHT*6, WIDTH, HEIGHT);
	    tree14 = tileSheet.crop(WIDTH*7, HEIGHT*6, WIDTH, HEIGHT);
	    tree15 = tileSheet.crop(0, HEIGHT*7, WIDTH, HEIGHT);
	    tree16 = tileSheet.crop(WIDTH, HEIGHT*7, WIDTH, HEIGHT);
	    tree17 = tileSheet.crop(WIDTH*2, HEIGHT*7, WIDTH, HEIGHT);
	    tree18 = tileSheet.crop(WIDTH*3, HEIGHT*7, WIDTH, HEIGHT);
	    tree19 = tileSheet.crop(WIDTH*4, HEIGHT*7, WIDTH, HEIGHT);
	    tree20 = tileSheet.crop(WIDTH*5, HEIGHT*7, WIDTH, HEIGHT);
	    tree21 = tileSheet.crop(WIDTH*6, HEIGHT*7, WIDTH, HEIGHT);
	    tree22 = tileSheet.crop(WIDTH*7, HEIGHT*7, WIDTH, HEIGHT);
	    tree23 = tileSheet.crop(0, HEIGHT*8, WIDTH, HEIGHT);
	    tree24 = tileSheet.crop(WIDTH, HEIGHT*8, WIDTH, HEIGHT);
	    tree25 = tileSheet.crop(WIDTH*2, HEIGHT*8, WIDTH, HEIGHT);
	    tree26 = tileSheet.crop(WIDTH*3, HEIGHT*8, WIDTH, HEIGHT);
	    tree27 = tileSheet.crop(WIDTH*4, HEIGHT*8, WIDTH, HEIGHT);
	    tree28 = tileSheet.crop(WIDTH*5, HEIGHT*8, WIDTH, HEIGHT);
	    tree29 = tileSheet.crop(WIDTH*6, HEIGHT*8, WIDTH, HEIGHT);
	    tree30 = tileSheet.crop(WIDTH*7, HEIGHT*8, WIDTH, HEIGHT);
	    tree31 = tileSheet.crop(0, HEIGHT*9, WIDTH, HEIGHT);
	    tree32 = tileSheet.crop(WIDTH, HEIGHT*9, WIDTH, HEIGHT);
	    tree33 = tileSheet.crop(WIDTH*2, HEIGHT*9, WIDTH, HEIGHT);
	    tree34 = tileSheet.crop(WIDTH*3, HEIGHT*9, WIDTH, HEIGHT);
	    tree35 = tileSheet.crop(WIDTH*4, HEIGHT*9, WIDTH, HEIGHT);
	    tree36 = tileSheet.crop(WIDTH*5, HEIGHT*9, WIDTH, HEIGHT);
	    tree37 = tileSheet.crop(WIDTH*6, HEIGHT*9, WIDTH, HEIGHT);
	    tree38 = tileSheet.crop(WIDTH*7, HEIGHT*9, WIDTH, HEIGHT);
	    tree39 = tileSheet.crop(0, HEIGHT*10, WIDTH, HEIGHT);
	    tree40 = tileSheet.crop(WIDTH, HEIGHT*10, WIDTH, HEIGHT);
	    tree41 = tileSheet.crop(WIDTH*2, HEIGHT*10, WIDTH, HEIGHT);
	    tree42 = tileSheet.crop(WIDTH*3, HEIGHT*10, WIDTH, HEIGHT);
	    tree43 = tileSheet.crop(WIDTH*4, HEIGHT*10, WIDTH, HEIGHT);
	    tree44 = tileSheet.crop(WIDTH*5, HEIGHT*10, WIDTH, HEIGHT);
	    tree45 = tileSheet.crop(WIDTH*6, HEIGHT*10, WIDTH, HEIGHT);
	    tree46 = tileSheet.crop(WIDTH*7, HEIGHT*10, WIDTH, HEIGHT);
	    tree47 = tileSheet.crop(0, HEIGHT*11, WIDTH, HEIGHT);
	    tree48 = tileSheet.crop(WIDTH, HEIGHT*11, WIDTH, HEIGHT);
	    tree49 = tileSheet.crop(WIDTH*2, HEIGHT*11, WIDTH, HEIGHT);
	    tree50 = tileSheet.crop(WIDTH*3, HEIGHT*11, WIDTH, HEIGHT);
	    tree51 = tileSheet.crop(WIDTH*4, HEIGHT*11, WIDTH, HEIGHT);
	    tree52 = tileSheet.crop(WIDTH*5, HEIGHT*11, WIDTH, HEIGHT);
	    tree53 = tileSheet.crop(WIDTH*6, HEIGHT*11, WIDTH, HEIGHT);
	    tree54 = tileSheet.crop(WIDTH*7, HEIGHT*11, WIDTH, HEIGHT);
	    tree55 = tileSheet.crop(0, HEIGHT*12, WIDTH, HEIGHT);
	    tree56 = tileSheet.crop(WIDTH, HEIGHT*12, WIDTH, HEIGHT);
	    tree57 = tileSheet.crop(WIDTH*2, HEIGHT*12, WIDTH, HEIGHT);
	    tree58 = tileSheet.crop(WIDTH*3, HEIGHT*12, WIDTH, HEIGHT);
	    tree59 = tileSheet.crop(WIDTH*4, HEIGHT*12, WIDTH, HEIGHT);
	    tree60 = tileSheet.crop(WIDTH*5, HEIGHT*12, WIDTH, HEIGHT);
	    tree61 = tileSheet.crop(WIDTH*6, HEIGHT*12, WIDTH, HEIGHT);
	    tree62 = tileSheet.crop(WIDTH*7, HEIGHT*12, WIDTH, HEIGHT);
	    tree63 = tileSheet.crop(WIDTH, HEIGHT*13, WIDTH, HEIGHT);
	    tree64 = tileSheet.crop(WIDTH*2, HEIGHT*13, WIDTH, HEIGHT);
	    tree65 = tileSheet.crop(WIDTH*3, HEIGHT*13, WIDTH, HEIGHT);
	    tree66 = tileSheet.crop(WIDTH*4, HEIGHT*13, WIDTH, HEIGHT);
	    tree67 = tileSheet.crop(WIDTH*5, HEIGHT*13, WIDTH, HEIGHT);
	    tree68 = tileSheet.crop(WIDTH*6, HEIGHT*13, WIDTH, HEIGHT);
	    tree69 = tileSheet.crop(WIDTH*2, HEIGHT*14, WIDTH, HEIGHT);
	    tree70 = tileSheet.crop(WIDTH*3, HEIGHT*14, WIDTH, HEIGHT);
	    tree71 = tileSheet.crop(WIDTH*4, HEIGHT*14, WIDTH, HEIGHT);
	    tree72 = tileSheet.crop(WIDTH*5, HEIGHT*14, WIDTH, HEIGHT);
	    //house
	    house1 = tileSheet.crop(WIDTH*12, HEIGHT*5, WIDTH, HEIGHT);
	    house2 = tileSheet.crop(WIDTH*13, HEIGHT*5, WIDTH, HEIGHT);
	    house3 = tileSheet.crop(WIDTH*14, HEIGHT*5, WIDTH, HEIGHT);
	    house4 = tileSheet.crop(WIDTH*15, HEIGHT*5, WIDTH, HEIGHT);
	    house5 = tileSheet.crop(WIDTH*17, HEIGHT*5, WIDTH, HEIGHT);
	    house6 = tileSheet.crop(WIDTH*18, HEIGHT*5, WIDTH, HEIGHT);
	    house7 = tileSheet.crop(WIDTH*19, HEIGHT*5, WIDTH, HEIGHT);
	    house8 = tileSheet.crop(WIDTH*12, HEIGHT*6, WIDTH, HEIGHT);
	    house9 = tileSheet.crop(WIDTH*13, HEIGHT*6, WIDTH, HEIGHT);
	    house10 = tileSheet.crop(WIDTH*14, HEIGHT*6, WIDTH, HEIGHT);
	    house11 = tileSheet.crop(WIDTH*15, HEIGHT*6, WIDTH, HEIGHT);
	    house12 = tileSheet.crop(WIDTH*16, HEIGHT*6, WIDTH, HEIGHT);
	    house13 = tileSheet.crop(WIDTH*17, HEIGHT*6, WIDTH, HEIGHT);
	    house14 = tileSheet.crop(WIDTH*18, HEIGHT*6, WIDTH, HEIGHT);
	    house15 = tileSheet.crop(WIDTH*19, HEIGHT*6, WIDTH, HEIGHT);
	    house16 = tileSheet.crop(WIDTH*13, HEIGHT*7, WIDTH, HEIGHT);
	    house17 = tileSheet.crop(WIDTH*14, HEIGHT*7, WIDTH, HEIGHT);
	    house18 = tileSheet.crop(WIDTH*15, HEIGHT*7, WIDTH, HEIGHT);
	    house19 = tileSheet.crop(WIDTH*16, HEIGHT*7, WIDTH, HEIGHT);
	    house20 = tileSheet.crop(WIDTH*17, HEIGHT*7, WIDTH, HEIGHT);
	    house21 = tileSheet.crop(WIDTH*18, HEIGHT*7, WIDTH, HEIGHT);
	    house22 = tileSheet.crop(WIDTH*19, HEIGHT*7, WIDTH, HEIGHT);
	    house23 = tileSheet.crop(WIDTH*13, HEIGHT*8, WIDTH, HEIGHT);
	    house24 = tileSheet.crop(WIDTH*15, HEIGHT*8, WIDTH, HEIGHT);
	    house25 = tileSheet.crop(WIDTH*16, HEIGHT*8, WIDTH, HEIGHT);
	    house26 = tileSheet.crop(WIDTH*17, HEIGHT*8, WIDTH, HEIGHT);
	    house27 = tileSheet.crop(WIDTH*18, HEIGHT*8, WIDTH, HEIGHT);
	    house28 = tileSheet.crop(WIDTH*19, HEIGHT*8, WIDTH, HEIGHT);
	    house29 = tileSheet.crop(WIDTH*12, HEIGHT*9, WIDTH, HEIGHT);
	    house30 = tileSheet.crop(WIDTH*13, HEIGHT*9, WIDTH, HEIGHT);
	    house31 = tileSheet.crop(WIDTH*15, HEIGHT*9, WIDTH, HEIGHT);
	    house32 = tileSheet.crop(WIDTH*16, HEIGHT*9, WIDTH, HEIGHT);
	    house33 = tileSheet.crop(WIDTH*17, HEIGHT*9, WIDTH, HEIGHT);
	    house34 = tileSheet.crop(WIDTH*18, HEIGHT*9, WIDTH, HEIGHT);
	    house35 = tileSheet.crop(WIDTH*19, HEIGHT*9, WIDTH, HEIGHT);
	    house36 = tileSheet.crop(WIDTH*12, HEIGHT*10, WIDTH, HEIGHT);
	    house37 = tileSheet.crop(WIDTH*13, HEIGHT*10, WIDTH, HEIGHT);
	    house38 = tileSheet.crop(WIDTH*15, HEIGHT*10, WIDTH, HEIGHT);
	    house39 = tileSheet.crop(WIDTH*16, HEIGHT*10, WIDTH, HEIGHT);
	    house40 = tileSheet.crop(WIDTH*17, HEIGHT*10, WIDTH, HEIGHT);
	    house41 = tileSheet.crop(WIDTH*18, HEIGHT*10, WIDTH, HEIGHT);
	    house42 = tileSheet.crop(WIDTH*19, HEIGHT*10, WIDTH, HEIGHT);
	    house43 = tileSheet.crop(WIDTH*12, HEIGHT*11, WIDTH, HEIGHT);
	    house44 = tileSheet.crop(WIDTH*13, HEIGHT*11, WIDTH, HEIGHT);
	    house45 = tileSheet.crop(WIDTH*14, HEIGHT*11, WIDTH, HEIGHT);
	    house46 = tileSheet.crop(WIDTH*15, HEIGHT*11, WIDTH, HEIGHT);
	    house47 = tileSheet.crop(WIDTH*16, HEIGHT*11, WIDTH, HEIGHT);
	    house48 = tileSheet.crop(WIDTH*17, HEIGHT*11, WIDTH, HEIGHT);
	    house49 = tileSheet.crop(WIDTH*12, HEIGHT*12, WIDTH, HEIGHT);
	    house50 = tileSheet.crop(WIDTH*13, HEIGHT*12, WIDTH, HEIGHT);
	    house51 = tileSheet.crop(WIDTH*14, HEIGHT*12, WIDTH, HEIGHT);
	    house52 = tileSheet.crop(WIDTH*15, HEIGHT*12, WIDTH, HEIGHT);
	    house53 = tileSheet.crop(WIDTH*16, HEIGHT*12, WIDTH, HEIGHT);
	    house54 = tileSheet.crop(WIDTH*16, HEIGHT*13, WIDTH, HEIGHT);
	    house55 = tileSheet.crop(WIDTH*17, HEIGHT*13, WIDTH, HEIGHT);
	    houseShadow1 = tileSheet.crop(WIDTH*14, HEIGHT*8, WIDTH, HEIGHT);
	    houseShadow2 = tileSheet.crop(WIDTH*14, HEIGHT*9, WIDTH, HEIGHT);
	    houseShadow3 = tileSheet.crop(WIDTH*14, HEIGHT*10, WIDTH, HEIGHT);
	  //cliff
	    cliff1 = tileSheet.crop(WIDTH*25, HEIGHT*9, WIDTH, HEIGHT);
	    cliff2 = tileSheet.crop(WIDTH*26, HEIGHT*9, WIDTH, HEIGHT);
	    cliff3 = tileSheet.crop(WIDTH*23, HEIGHT*10, WIDTH, HEIGHT);
	    cliff4 = tileSheet.crop(WIDTH*25, HEIGHT*10, WIDTH, HEIGHT);
	    cliff5 = tileSheet.crop(WIDTH*26, HEIGHT*10, WIDTH, HEIGHT);
	    cliff6 = tileSheet.crop(WIDTH*28, HEIGHT*10, WIDTH, HEIGHT);
	    cliff7 = tileSheet.crop(WIDTH*22, HEIGHT*11, WIDTH, HEIGHT);
	    cliff8 = tileSheet.crop(WIDTH*23, HEIGHT*11, WIDTH, HEIGHT);
	    cliff9 = tileSheet.crop(WIDTH*25, HEIGHT*11, WIDTH, HEIGHT);
	    cliff10 = tileSheet.crop(WIDTH*26, HEIGHT*11, WIDTH, HEIGHT);
		cliff11 = tileSheet.crop(WIDTH*28, HEIGHT*11, WIDTH, HEIGHT);
		cliff12 = tileSheet.crop(WIDTH*29, HEIGHT*11, WIDTH, HEIGHT);
		cliff13 = tileSheet.crop(WIDTH*22, HEIGHT*12, WIDTH, HEIGHT);
		cliff14 = tileSheet.crop(WIDTH*23, HEIGHT*12, WIDTH, HEIGHT);
		cliff15 = tileSheet.crop(WIDTH*24, HEIGHT*12, WIDTH, HEIGHT);
		cliff16 = tileSheet.crop(WIDTH*25, HEIGHT*12, WIDTH, HEIGHT);
		cliff17 = tileSheet.crop(WIDTH*26, HEIGHT*12, WIDTH, HEIGHT);
		cliff18 = tileSheet.crop(WIDTH*27, HEIGHT*12, WIDTH, HEIGHT);
		cliff19 = tileSheet.crop(WIDTH*28, HEIGHT*12, WIDTH, HEIGHT);
		cliff20 = tileSheet.crop(WIDTH*29, HEIGHT*12, WIDTH, HEIGHT);
		cliff21 = tileSheet.crop(WIDTH*22, HEIGHT*13, WIDTH, HEIGHT);
		cliff22 = tileSheet.crop(WIDTH*23, HEIGHT*13, WIDTH, HEIGHT);
		cliff23 = tileSheet.crop(WIDTH*24, HEIGHT*13, WIDTH, HEIGHT);
		cliff24 = tileSheet.crop(WIDTH*27, HEIGHT*13, WIDTH, HEIGHT);
		cliff25 = tileSheet.crop(WIDTH*28, HEIGHT*13, WIDTH, HEIGHT);
		cliff26 = tileSheet.crop(WIDTH*29, HEIGHT*13, WIDTH, HEIGHT);
		cliff27 = tileSheet.crop(WIDTH*22, HEIGHT*14, WIDTH, HEIGHT);
		cliff28 = tileSheet.crop(WIDTH*23, HEIGHT*14, WIDTH, HEIGHT);
		cliff29 = tileSheet.crop(WIDTH*24, HEIGHT*14, WIDTH, HEIGHT);
		cliff30 = tileSheet.crop(WIDTH*27, HEIGHT*14, WIDTH, HEIGHT);
		cliff31 = tileSheet.crop(WIDTH*28, HEIGHT*14, WIDTH, HEIGHT);
		cliff32 = tileSheet.crop(WIDTH*29, HEIGHT*14, WIDTH, HEIGHT);
		cliff33 = tileSheet.crop(WIDTH*22, HEIGHT*16, WIDTH, HEIGHT);
		cliff34 = tileSheet.crop(WIDTH*23, HEIGHT*16, WIDTH, HEIGHT);
		cliff35 = tileSheet.crop(WIDTH*24, HEIGHT*16, WIDTH, HEIGHT);
		cliff36 = tileSheet.crop(WIDTH*25, HEIGHT*16, WIDTH, HEIGHT);
		cliff37 = tileSheet.crop(WIDTH*26, HEIGHT*16, WIDTH, HEIGHT);
		cliff38 = tileSheet.crop(WIDTH*27, HEIGHT*16, WIDTH, HEIGHT);
		cliff39 = tileSheet.crop(WIDTH*28, HEIGHT*16, WIDTH, HEIGHT);
		cliff40 = tileSheet.crop(WIDTH*29, HEIGHT*16, WIDTH, HEIGHT);
		cliff41 = tileSheet.crop(WIDTH*22, HEIGHT*17, WIDTH, HEIGHT);
		cliff42 = tileSheet.crop(WIDTH*23, HEIGHT*17, WIDTH, HEIGHT);
		cliff43 = tileSheet.crop(WIDTH*24, HEIGHT*17, WIDTH, HEIGHT);
		cliff44 = tileSheet.crop(WIDTH*25, HEIGHT*17, WIDTH, HEIGHT);
		cliff45 = tileSheet.crop(WIDTH*26, HEIGHT*17, WIDTH, HEIGHT);
		cliff46 = tileSheet.crop(WIDTH*27, HEIGHT*17, WIDTH, HEIGHT);
		cliff47 = tileSheet.crop(WIDTH*28, HEIGHT*17, WIDTH, HEIGHT);
		cliff48 = tileSheet.crop(WIDTH*29, HEIGHT*17, WIDTH, HEIGHT);
		cliff49 = tileSheet.crop(WIDTH*23, HEIGHT*18, WIDTH, HEIGHT);
		cliff50 = tileSheet.crop(WIDTH*24, HEIGHT*18, WIDTH, HEIGHT);
		cliff51 = tileSheet.crop(WIDTH*25, HEIGHT*18, WIDTH, HEIGHT);
		cliff52 = tileSheet.crop(WIDTH*26, HEIGHT*18, WIDTH, HEIGHT);
		cliff53 = tileSheet.crop(WIDTH*27, HEIGHT*18, WIDTH, HEIGHT);
		cliff54 = tileSheet.crop(WIDTH*28, HEIGHT*18, WIDTH, HEIGHT);
		cliff55 = tileSheet.crop(WIDTH*23, HEIGHT*19, WIDTH, HEIGHT);
		cliff56 = tileSheet.crop(WIDTH*24, HEIGHT*19, WIDTH, HEIGHT);
		cliff57 = tileSheet.crop(WIDTH*25, HEIGHT*19, WIDTH, HEIGHT);
		cliff58 = tileSheet.crop(WIDTH*26, HEIGHT*19, WIDTH, HEIGHT);
		cliff59 = tileSheet.crop(WIDTH*27, HEIGHT*19, WIDTH, HEIGHT);
		cliff60 = tileSheet.crop(WIDTH*28, HEIGHT*19, WIDTH, HEIGHT);
		cliff61 = tileSheet.crop(WIDTH*24, HEIGHT*20, WIDTH, HEIGHT);
		cliff62 = tileSheet.crop(WIDTH*25, HEIGHT*20, WIDTH, HEIGHT);
		cliff63 = tileSheet.crop(WIDTH*26, HEIGHT*20, WIDTH, HEIGHT);
		cliff64 = tileSheet.crop(WIDTH*27, HEIGHT*20, WIDTH, HEIGHT);
		cliff65 = tileSheet.crop(WIDTH*24, HEIGHT*21, WIDTH, HEIGHT);
		cliff66 = tileSheet.crop(WIDTH*25, HEIGHT*21, WIDTH, HEIGHT);
		cliff67 = tileSheet.crop(WIDTH*26, HEIGHT*21, WIDTH, HEIGHT);
		cliff68 = tileSheet.crop(WIDTH*27, HEIGHT*21, WIDTH, HEIGHT);
	    //Hedge
	    hedge1 = tileSheet.crop(WIDTH*15, HEIGHT, WIDTH, HEIGHT);
	    hedge2 = tileSheet.crop(WIDTH*16, HEIGHT, WIDTH, HEIGHT);
	    hedge3 = tileSheet.crop(WIDTH*15, HEIGHT*2, WIDTH, HEIGHT);
	    hedge4 = tileSheet.crop(WIDTH*16, HEIGHT*2, WIDTH, HEIGHT);
	    hedge5 = tileSheet.crop(WIDTH*15, HEIGHT*3, WIDTH, HEIGHT);
	    hedge6 = tileSheet.crop(WIDTH*16, HEIGHT*3, WIDTH, HEIGHT);
	    hedge7 = tileSheet.crop(WIDTH*15, HEIGHT*4, WIDTH, HEIGHT);
	    hedge8 = tileSheet.crop(WIDTH*16, HEIGHT*4, WIDTH, HEIGHT);
		hedge9 = tileSheet.crop(WIDTH*14, HEIGHT, WIDTH, HEIGHT);
		hedge10 = tileSheet.crop(WIDTH*14, HEIGHT*2, WIDTH, HEIGHT);
		hedge11 = tileSheet.crop(WIDTH*14, HEIGHT*3, WIDTH, HEIGHT);
	    //full ones.
	    treeFull = tileSheet.crop(0, HEIGHT*5, WIDTH*8, HEIGHT*10);
	    stumpFull = tileSheet.crop(WIDTH*8, HEIGHT*5, WIDTH*4, HEIGHT*4);
	    stumpTreeFull = tileSheet.crop(WIDTH*8, HEIGHT*9, WIDTH*4, HEIGHT*4); 
	    bushFull = tileSheet.crop(0, HEIGHT*3, WIDTH*2, HEIGHT*2);
	    rockFull = tileSheet.crop(WIDTH*2, HEIGHT*3, WIDTH*2, HEIGHT*2);
	    strucFull = tileSheet.crop(WIDTH*4, HEIGHT*3, WIDTH*2, HEIGHT*2);
	    tallgrassFull = tileSheet.crop(WIDTH*6, HEIGHT*3, WIDTH*2, HEIGHT*2);
	    signFull = tileSheet.crop(WIDTH*8, HEIGHT*3, WIDTH*2, HEIGHT*2);
	    fenceFull = tileSheet.crop(WIDTH*12, HEIGHT*3, WIDTH*2, HEIGHT*2);
	    mushroomGroupFull = tileSheet.crop(WIDTH*11, WIDTH, WIDTH*2, HEIGHT*2);
	}
	
	public static void initAnimations()
	{
		playerHeadDirections = new BufferedImage[4];
		playerWalkingUp = new BufferedImage[4];
		playerWalkingDown = new BufferedImage[4];
		playerWalkingLeft = new BufferedImage[4];
		playerWalkingRight = new BufferedImage[4];
		playerStanding = new BufferedImage[4];
		playerAttackingUp = new BufferedImage[4];
		playerAttackingDown = new BufferedImage[4];
		playerAttackingLeft = new BufferedImage[4];
		playerAttackingRight = new BufferedImage[4];
		//playerSword
		playerSwordUp = new BufferedImage[5];
		playerSwordDown = new BufferedImage[5];
		playerSwordLeft = new BufferedImage[5];
		playerSwordRight = new BufferedImage[5]; 
		 
		baddyHeadDirections = new BufferedImage[4];
		baddyWalkingUp = new BufferedImage[4];
		baddyWalkingDown = new BufferedImage[4];
		baddyWalkingLeft = new BufferedImage[4];
		baddyWalkingRight = new BufferedImage[4];
		baddyStanding = new BufferedImage[4];

		grassParticleAnimations = new BufferedImage[2];
		
		int x = 6;
		int y = 0;
		for(int i = 0; i < playerHeadDirections.length; i++)
		{
			x+=2;
			playerHeadDirections[i] = entitySheet.crop(WIDTH*x, HEIGHT*y, WIDTH*2, HEIGHT*2);
		}
		x = 6;
		y = 10;
		for(int i = 0; i < baddyHeadDirections.length; i++)
		{
			x+=2;
			baddyHeadDirections[i] = entitySheet.crop(WIDTH*x, HEIGHT*y, WIDTH*2, HEIGHT*2);
		}
		x = 0;
		y = 0;
		for(int i = 0; i < playerWalkingUp.length; i++)
		{
			y+=2;
			playerWalkingUp[i] = entitySheet.crop(WIDTH*x, HEIGHT*y, WIDTH*2, HEIGHT*2);
		}
		x = 2;
		y = 0;
		for(int i = 0; i < playerWalkingLeft.length; i++)
		{
			y+=2;
			playerWalkingLeft[i] = entitySheet.crop(WIDTH*x, HEIGHT*y, WIDTH*2, HEIGHT*2);
		}
		x = 4;
		y = 0;
		for(int i = 0; i < playerWalkingDown.length; i++)
		{
			y+=2;
			playerWalkingDown[i] = entitySheet.crop(WIDTH*x, HEIGHT*y, WIDTH*2, HEIGHT*2);
		}
		x = 6;
		y = 0;
		for(int i = 0; i < playerWalkingRight.length; i++)
		{
			y+=2;
			playerWalkingRight[i] = entitySheet.crop(WIDTH*x, HEIGHT*y, WIDTH*2, HEIGHT*2);
		}
		x=-2;
		y=0;
		for(int i = 0; i < playerStanding.length; i++)
		{
			x+=2;
			playerStanding[i] = entitySheet.crop(WIDTH*x, HEIGHT*y, WIDTH*2, HEIGHT*2);
		}
		//Attacking---------------------------------------------------------------------------
		x=8;
		y=0;
		for(int i = 0; i < playerAttackingUp.length; i++)
		{
			y+=2;
			playerAttackingUp[i] = entitySheet.crop(WIDTH*x, HEIGHT*y, WIDTH*2, HEIGHT*2);
		}
		x=10;
		y=0;
		for(int i = 0; i < playerAttackingLeft.length; i++)
		{
			y+=2;
			playerAttackingLeft[i] = entitySheet.crop(WIDTH*x, HEIGHT*y, WIDTH*2, HEIGHT*2);
		}
		x=12;
		y=0;
		for(int i = 0; i < playerAttackingDown.length; i++)
		{
			y+=2;
			playerAttackingDown[i] = entitySheet.crop(WIDTH*x, HEIGHT*y, WIDTH*2, HEIGHT*2);
		}
		x=14;
		y=0;
		for(int i = 0; i < playerAttackingRight.length; i++)
		{
			y+=2;
			playerAttackingRight[i] = entitySheet.crop(WIDTH*x, HEIGHT*y, WIDTH*2, HEIGHT*2);
		}
		//Sword---------------------------------------------------------------------------------
		x=14;
		y=2;
		for(int i = 0; i < playerSwordUp.length; i++)
		{
			x+=2;
			playerSwordUp[i] = entitySheet.crop(WIDTH*x, HEIGHT*y, WIDTH*2, HEIGHT*2);
		}
		x=14;
		y=4;
		for(int i = 0; i < playerSwordDown.length; i++)
		{
			x+=2;
			playerSwordDown[i] = entitySheet.crop(WIDTH*x, HEIGHT*y, WIDTH*2, HEIGHT*2);
		}
		x=14;
		y=6;
		for(int i = 0; i < playerSwordLeft.length; i++)
		{
			x+=2;
			playerSwordLeft[i] = entitySheet.crop(WIDTH*x, HEIGHT*y, WIDTH*2, HEIGHT*2);
		}
		x=14;
		y=8;
		for(int i = 0; i < playerSwordRight.length; i++)
		{
			x+=2;
			playerSwordRight[i] = entitySheet.crop(WIDTH*x, HEIGHT*y, WIDTH*2, HEIGHT*2);
		}
		//-----------------------------------------------------------------------------------
		x = 0;
		y = 10;
		for(int i = 0; i < baddyWalkingUp.length; i++)
		{
			y+=2;
			baddyWalkingUp[i] = entitySheet.crop(WIDTH*x, HEIGHT*y, WIDTH*2, HEIGHT*2);
		}
		x = 2;
		y = 10;
		for(int i = 0; i < baddyWalkingLeft.length; i++)
		{
			y+=2;
			baddyWalkingLeft[i] = entitySheet.crop(WIDTH*x, HEIGHT*y, WIDTH*2, HEIGHT*2);
		}
		x = 4;
		y = 10;
		for(int i = 0; i < baddyWalkingDown.length; i++)
		{
			y+=2;
			baddyWalkingDown[i] = entitySheet.crop(WIDTH*x, HEIGHT*y, WIDTH*2, HEIGHT*2);
		}
		x = 6;
		y = 10;
		for(int i = 0; i < baddyWalkingRight.length; i++)
		{
			y+=2;
			baddyWalkingRight[i] = entitySheet.crop(WIDTH*x, HEIGHT*y, WIDTH*2, HEIGHT*2);
		}
		x=-2;
		y=10;
		for(int i = 0; i < baddyStanding.length; i++)
		{
			x+=2;
			baddyStanding[i] = entitySheet.crop(WIDTH*x, HEIGHT*y, WIDTH*2, HEIGHT*2);
		}
		
		grassParticleAnimations[0] = tileSheet.crop(WIDTH*27, HEIGHT*30, WIDTH*2, HEIGHT);
		grassParticleAnimations[1] = tileSheet.crop(WIDTH*27, HEIGHT*31, WIDTH*2, HEIGHT);
	}
}