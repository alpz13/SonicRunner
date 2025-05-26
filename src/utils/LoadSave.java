package utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;

public class LoadSave {
    public static final String PLAYER_ATLAS = "player/player_sprites.png";
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
