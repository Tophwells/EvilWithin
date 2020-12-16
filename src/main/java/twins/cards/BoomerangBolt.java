package twins.cards;

import twins.DonuDecaMod;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.ReduceCostAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.vfx.combat.CleaveEffect;

public class BoomerangBolt extends AbstractTwinsCard {

    public final static String ID = makeID("BoomerangBolt");

    //stupid intellij stuff attack, enemy, rare

    private static final int DAMAGE = 18;
    private static final int UPG_DAMAGE = 4;

    public BoomerangBolt() {
        super(ID, 3, CardType.ATTACK, CardRarity.RARE, CardTarget.ENEMY);
        baseDamage = DAMAGE;
        isMultiDamage = true;
        tags.add(DonuDecaMod.BLASTER);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        atb(new VFXAction(p, new CleaveEffect(), 0.0F));
        allDmg(AbstractGameAction.AttackEffect.NONE);
        atb(new ReduceCostAction(this));
    }

    public void upp() {
        upgradeDamage(UPG_DAMAGE);
    }
}