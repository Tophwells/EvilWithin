package twins.cards;

import twins.DonuDecaMod;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDrawPileAction;
import com.megacrit.cardcrawl.cards.status.VoidCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class SuperDuperBeam extends AbstractTwinsCard {

    public final static String ID = makeID("SuperDuperBeam");

    //stupid intellij stuff attack, all_enemy, rare

    private static final int DAMAGE = 45;
    private static final int MAGIC = 5;
    private static final int UPG_MAGIC = -2;

    public SuperDuperBeam() {
        super(ID, 4, CardType.ATTACK, CardRarity.RARE, CardTarget.ENEMY);
        baseDamage = DAMAGE;
        baseMagicNumber = magicNumber = MAGIC;
        isMultiDamage = true;
        tags.add(DonuDecaMod.BLASTER);
        cardsToPreview = new VoidCard();
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        //TODO: Copy beam laser effect
        allDmg(AbstractGameAction.AttackEffect.FIRE);
        atb(new MakeTempCardInDrawPileAction(new VoidCard(), magicNumber, false, true));
    }

    public void upp() {
        upgradeDamage(5);
        upgradeMagicNumber(UPG_MAGIC);
    }
}