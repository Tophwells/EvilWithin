package evilWithin.patches.ui.campfire;

import com.evacipated.cardcrawl.modthespire.lib.*;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.rooms.CampfireUI;
import com.megacrit.cardcrawl.ui.campfire.AbstractCampfireOption;
import evilWithin.relics.GremlinWheel;
import evilWithin.ui.campfire.WheelSpinButton;
import guardian.GuardianMod;
import guardian.characters.GuardianCharacter;
import guardian.relics.PickAxe;
import guardian.ui.EnhanceBonfireOption;
import guardian.ui.FindGemsOption;
import javassist.CtBehavior;

import java.util.ArrayList;

public class AddWheelSpinButtonPatch {
    @SpirePatch(clz = CampfireUI.class, method = "initializeButtons")
    public static class AddKeys {
        @SpireInsertPatch(locator = Locator.class)
        public static void patch(CampfireUI __instance, ArrayList<AbstractCampfireOption> ___buttons) {
            if (AbstractDungeon.player.hasRelic(GremlinWheel.ID)) {
                boolean relicActive;
                relicActive = AbstractDungeon.player.getRelic(GremlinWheel.ID).counter != 0;
                ___buttons.add(new WheelSpinButton(relicActive));
            }
        }
    }

    public static class Locator extends SpireInsertLocator {
        @Override
        public int[] Locate(CtBehavior ctBehavior) throws Exception {
            Matcher finalMatcher = new Matcher.FieldAccessMatcher(AbstractPlayer.class, "relics");
            return LineFinder.findInOrder(ctBehavior, finalMatcher);
        }
    }
}