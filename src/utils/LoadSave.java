package utils;

import entities.PlayerCharacter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;

public class LoadSave {

    public static final String PLAYER_PIRATE = "player/player_sprites.png";
    public static final String PLAYER_ORC = "player/player_orc.png";
    public static final String PLAYER_SOLDIER = "player/player_soldier.png";
    public static final String LEVEL_ATLAS = "ui/outside_sprites.png";
    public static final String MENU_BUTTONS = "menu/button_atlas.png";
    public static final String MENU_BACKGROUND = "menu/menu_background.png";
    public static final String PAUSE_BACKGROUND = "pause/pause_menu.png";
    public static final String SOUND_BUTTONS = "pause/sound_button.png";
    public static final String URM_BUTTONS = "pause/urm_buttons.png";
    public static final String VOLUME_BUTTONS = "pause/volume_buttons.png";
    public static final String MENU_BACKGROUND_IMG = "menu/background_menu.png";
    public static final String PLAYING_BG_IMG = "background/playing_bg_img.png";
    public static final String BIG_CLOUDS = "background/big_clouds.png";
    public static final String SMALL_CLOUDS = "background/small_clouds.png";
    public static final String CRABBY_SPRITE = "enemies/crabby_sprite.png";
    public static final String STATUS_BAR = "ui/health_power_bar.png";
    public static final String COMPLETED_IMG = "ui/completed_sprite.png";
    public static final String POTION_ATLAS = "obj/potions_sprites.png";
    public static final String CONTAINER_ATLAS = "obj/objects_sprites.png";
    public static final String TRAP_ATLAS = "obj/trap_atlas.png";
    public static final String CANNON_ATLAS = "obj/cannon_atlas.png";
    public static final String CANNON_BALL = "obj/ball.png";
    public static final String DEATH_SCREEN = "menu/death_screen.png";
    public static final String OPTIONS_MENU = "menu/options_background.png";
    public static final String PINKSTAR_ATLAS = "enemies/pinkstar_atlas.png";
    public static final String QUESTION_ATLAS = "extras/question_atlas.png";
    public static final String EXCLAMATION_ATLAS = "extras/exclamation_atlas.png";
    public static final String SHARK_ATLAS = "enemies/shark_atlas.png";
    public static final String CREDITS = "menu/background_menu.png";
    public static final String GRASS_ATLAS = "obj/grass_atlas.png";
    public static final String TREE_ONE_ATLAS = "obj/tree_one_atlas.png";
    public static final String TREE_TWO_ATLAS = "obj/tree_two_atlas.png";
    public static final String GAME_COMPLETED = "ui/game_completed.png";
    public static final String RAIN_PARTICLE = "obj/rain_particle.png";
    public static final String WATER_TOP = "obj/water_atlas_animation.png";
    public static final String WATER_BOTTOM = "obj/water.png";
    public static final String SHIP = "obj/ship.png";

    public static BufferedImage[][] loadAnimations(PlayerCharacter pc) {
        BufferedImage img = LoadSave.GetSpriteAtlas(pc.playerAtlas);
        BufferedImage[][] animations = new BufferedImage[pc.rowA][pc.colA];
        for (int j = 0; j < animations.length; j++)
            for (int i = 0; i < animations[j].length; i++)
                animations[j][i] = img.getSubimage(i * pc.spriteW, j * pc.spriteH, pc.spriteW, pc.spriteH);

        return animations;
    }

    public static BufferedImage GetSpriteAtlas(String filename) {
        BufferedImage img = null;
        InputStream is = LoadSave.class.getResourceAsStream("/" + filename);
        try {
            img = ImageIO.read(is);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return img;
    }

    public static BufferedImage[] GetAllLevels() {
        URL url = LoadSave.class.getResource("/lvls/");
        System.out.println(url);
        File file = null;

        try {
            file = new File(url.toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        File[] files = file.listFiles();
        File[] filesSorted = new File[files.length];

        for (int i = 0; i < filesSorted.length; i++)
            for (int j = 0; j < files.length; j++) {
                if (files[j].getName().equals((i + 1) + ".png"))
                    filesSorted[i] = files[j];

            }

        BufferedImage[] imgs = new BufferedImage[filesSorted.length];

        for (int i = 0; i < imgs.length; i++)
            try {
                imgs[i] = ImageIO.read(filesSorted[i]);
            } catch (IOException e) {
                e.printStackTrace();
            }

        return imgs;
    }
}
