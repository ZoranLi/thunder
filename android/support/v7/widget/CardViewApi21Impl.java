package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;

@RequiresApi(21)
class CardViewApi21Impl implements CardViewImpl {
    public void initStatic() {
    }

    CardViewApi21Impl() {
    }

    public void initialize(CardViewDelegate cardViewDelegate, Context context, ColorStateList colorStateList, float f, float f2, float f3) {
        cardViewDelegate.setCardBackground(new RoundRectDrawable(colorStateList, f));
        context = cardViewDelegate.getCardView();
        context.setClipToOutline(true);
        context.setElevation(f2);
        setMaxElevation(cardViewDelegate, f3);
    }

    public void setRadius(CardViewDelegate cardViewDelegate, float f) {
        getCardBackground(cardViewDelegate).setRadius(f);
    }

    public void setMaxElevation(CardViewDelegate cardViewDelegate, float f) {
        getCardBackground(cardViewDelegate).setPadding(f, cardViewDelegate.getUseCompatPadding(), cardViewDelegate.getPreventCornerOverlap());
        updatePadding(cardViewDelegate);
    }

    public float getMaxElevation(CardViewDelegate cardViewDelegate) {
        return getCardBackground(cardViewDelegate).getPadding();
    }

    public float getMinWidth(CardViewDelegate cardViewDelegate) {
        return getRadius(cardViewDelegate) * 2.0f;
    }

    public float getMinHeight(CardViewDelegate cardViewDelegate) {
        return getRadius(cardViewDelegate) * 2.0f;
    }

    public float getRadius(CardViewDelegate cardViewDelegate) {
        return getCardBackground(cardViewDelegate).getRadius();
    }

    public void setElevation(CardViewDelegate cardViewDelegate, float f) {
        cardViewDelegate.getCardView().setElevation(f);
    }

    public float getElevation(CardViewDelegate cardViewDelegate) {
        return cardViewDelegate.getCardView().getElevation();
    }

    public void updatePadding(CardViewDelegate cardViewDelegate) {
        if (cardViewDelegate.getUseCompatPadding()) {
            float maxElevation = getMaxElevation(cardViewDelegate);
            float radius = getRadius(cardViewDelegate);
            int ceil = (int) Math.ceil((double) RoundRectDrawableWithShadow.calculateHorizontalPadding(maxElevation, radius, cardViewDelegate.getPreventCornerOverlap()));
            int ceil2 = (int) Math.ceil((double) RoundRectDrawableWithShadow.calculateVerticalPadding(maxElevation, radius, cardViewDelegate.getPreventCornerOverlap()));
            cardViewDelegate.setShadowPadding(ceil, ceil2, ceil, ceil2);
            return;
        }
        cardViewDelegate.setShadowPadding(0, 0, 0, 0);
    }

    public void onCompatPaddingChanged(CardViewDelegate cardViewDelegate) {
        setMaxElevation(cardViewDelegate, getMaxElevation(cardViewDelegate));
    }

    public void onPreventCornerOverlapChanged(CardViewDelegate cardViewDelegate) {
        setMaxElevation(cardViewDelegate, getMaxElevation(cardViewDelegate));
    }

    public void setBackgroundColor(CardViewDelegate cardViewDelegate, @Nullable ColorStateList colorStateList) {
        getCardBackground(cardViewDelegate).setColor(colorStateList);
    }

    public ColorStateList getBackgroundColor(CardViewDelegate cardViewDelegate) {
        return getCardBackground(cardViewDelegate).getColor();
    }

    private RoundRectDrawable getCardBackground(CardViewDelegate cardViewDelegate) {
        return (RoundRectDrawable) cardViewDelegate.getCardBackground();
    }
}
