package android.support.transition;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v4.util.ArrayMap;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import android.view.ViewGroup;
import java.io.IOException;
import java.lang.reflect.Constructor;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class TransitionInflater {
    private static final ArrayMap<String, Constructor> CONSTRUCTORS = new ArrayMap();
    private static final Class<?>[] CONSTRUCTOR_SIGNATURE = new Class[]{Context.class, AttributeSet.class};
    private final Context mContext;

    private TransitionInflater(@NonNull Context context) {
        this.mContext = context;
    }

    public static TransitionInflater from(Context context) {
        return new TransitionInflater(context);
    }

    public Transition inflateTransition(int i) {
        i = this.mContext.getResources().getXml(i);
        try {
            Transition createTransitionFromXml = createTransitionFromXml(i, Xml.asAttributeSet(i), null);
            i.close();
            return createTransitionFromXml;
        } catch (Throwable e) {
            throw new InflateException(e.getMessage(), e);
        } catch (Throwable e2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(i.getPositionDescription());
            stringBuilder.append(": ");
            stringBuilder.append(e2.getMessage());
            throw new InflateException(stringBuilder.toString(), e2);
        } catch (Throwable th) {
            i.close();
        }
    }

    public TransitionManager inflateTransitionManager(int i, ViewGroup viewGroup) {
        InflateException inflateException;
        i = this.mContext.getResources().getXml(i);
        try {
            viewGroup = createTransitionManagerFromXml(i, Xml.asAttributeSet(i), viewGroup);
            i.close();
            return viewGroup;
        } catch (ViewGroup viewGroup2) {
            inflateException = new InflateException(viewGroup2.getMessage());
            inflateException.initCause(viewGroup2);
            throw inflateException;
        } catch (ViewGroup viewGroup22) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(i.getPositionDescription());
            stringBuilder.append(": ");
            stringBuilder.append(viewGroup22.getMessage());
            inflateException = new InflateException(stringBuilder.toString());
            inflateException.initCause(viewGroup22);
            throw inflateException;
        } catch (Throwable th) {
            i.close();
        }
    }

    private Transition createTransitionFromXml(XmlPullParser xmlPullParser, AttributeSet attributeSet, Transition transition) throws XmlPullParserException, IOException {
        Transition transition2;
        int depth = xmlPullParser.getDepth();
        TransitionSet transitionSet = transition instanceof TransitionSet ? (TransitionSet) transition : null;
        loop0:
        while (true) {
            transition2 = null;
            while (true) {
                int next = xmlPullParser.next();
                if ((next != 3 || xmlPullParser.getDepth() > depth) && next != 1) {
                    if (next == 2) {
                        String name = xmlPullParser.getName();
                        if ("fade".equals(name)) {
                            transition2 = new Fade(this.mContext, attributeSet);
                        } else if ("changeBounds".equals(name)) {
                            transition2 = new ChangeBounds(this.mContext, attributeSet);
                        } else if ("slide".equals(name)) {
                            transition2 = new Slide(this.mContext, attributeSet);
                        } else if ("explode".equals(name)) {
                            transition2 = new Explode(this.mContext, attributeSet);
                        } else if ("changeImageTransform".equals(name)) {
                            transition2 = new ChangeImageTransform(this.mContext, attributeSet);
                        } else if ("changeTransform".equals(name)) {
                            transition2 = new ChangeTransform(this.mContext, attributeSet);
                        } else if ("changeClipBounds".equals(name)) {
                            transition2 = new ChangeClipBounds(this.mContext, attributeSet);
                        } else if ("autoTransition".equals(name)) {
                            transition2 = new AutoTransition(this.mContext, attributeSet);
                        } else if ("changeScroll".equals(name)) {
                            transition2 = new ChangeScroll(this.mContext, attributeSet);
                        } else if ("transitionSet".equals(name)) {
                            transition2 = new TransitionSet(this.mContext, attributeSet);
                        } else if ("transition".equals(name)) {
                            transition2 = (Transition) createCustom(attributeSet, Transition.class, "transition");
                        } else if ("targets".equals(name)) {
                            getTargetIds(xmlPullParser, attributeSet, transition);
                        } else if ("arcMotion".equals(name)) {
                            if (transition == null) {
                                throw new RuntimeException("Invalid use of arcMotion element");
                            }
                            transition.setPathMotion(new ArcMotion(this.mContext, attributeSet));
                        } else if ("pathMotion".equals(name)) {
                            if (transition == null) {
                                throw new RuntimeException("Invalid use of pathMotion element");
                            }
                            transition.setPathMotion((PathMotion) createCustom(attributeSet, PathMotion.class, "pathMotion"));
                        } else if (!"patternPathMotion".equals(name)) {
                            transition = new StringBuilder("Unknown scene name: ");
                            transition.append(xmlPullParser.getName());
                            throw new RuntimeException(transition.toString());
                        } else if (transition == null) {
                            throw new RuntimeException("Invalid use of patternPathMotion element");
                        } else {
                            transition.setPathMotion(new PatternPathMotion(this.mContext, attributeSet));
                        }
                        if (transition2 == null) {
                            continue;
                        } else {
                            if (!xmlPullParser.isEmptyElementTag()) {
                                createTransitionFromXml(xmlPullParser, attributeSet, transition2);
                            }
                            if (transitionSet != null) {
                                break;
                            } else if (transition != null) {
                                throw new InflateException("Could not add transition to another transition.");
                            }
                        }
                    }
                }
            }
            transitionSet.addTransition(transition2);
        }
        return transition2;
    }

    private Object createCustom(AttributeSet attributeSet, Class cls, String str) {
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        if (attributeValue == null) {
            cls = new StringBuilder();
            cls.append(str);
            cls.append(" tag must have a 'class' attribute");
            throw new InflateException(cls.toString());
        }
        try {
            synchronized (CONSTRUCTORS) {
                Constructor constructor = (Constructor) CONSTRUCTORS.get(attributeValue);
                if (constructor == null) {
                    Class asSubclass = this.mContext.getClassLoader().loadClass(attributeValue).asSubclass(cls);
                    if (asSubclass != null) {
                        constructor = asSubclass.getConstructor(CONSTRUCTOR_SIGNATURE);
                        constructor.setAccessible(true);
                        CONSTRUCTORS.put(attributeValue, constructor);
                    }
                }
                attributeSet = constructor.newInstance(new Object[]{this.mContext, attributeSet});
            }
            return attributeSet;
        } catch (AttributeSet attributeSet2) {
            StringBuilder stringBuilder = new StringBuilder("Could not instantiate ");
            stringBuilder.append(cls);
            stringBuilder.append(" class ");
            stringBuilder.append(attributeValue);
            throw new InflateException(stringBuilder.toString(), attributeSet2);
        }
    }

    private void getTargetIds(XmlPullParser xmlPullParser, AttributeSet attributeSet, Transition transition) throws XmlPullParserException, IOException {
        TypedArray obtainStyledAttributes;
        int depth = xmlPullParser.getDepth();
        while (true) {
            int next = xmlPullParser.next();
            if ((next == 3 && xmlPullParser.getDepth() <= depth) || next == 1) {
                return;
            }
            String namedString;
            if (next == 2) {
                if (xmlPullParser.getName().equals("target")) {
                    obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, Styleable.TRANSITION_TARGET);
                    int namedResourceId = TypedArrayUtils.getNamedResourceId(obtainStyledAttributes, xmlPullParser, "targetId", 1, 0);
                    if (namedResourceId != 0) {
                        transition.addTarget(namedResourceId);
                    } else {
                        int namedResourceId2 = TypedArrayUtils.getNamedResourceId(obtainStyledAttributes, xmlPullParser, "excludeId", 2, 0);
                        if (namedResourceId2 != 0) {
                            transition.excludeTarget(namedResourceId2, true);
                        } else {
                            String namedString2 = TypedArrayUtils.getNamedString(obtainStyledAttributes, xmlPullParser, "targetName", 4);
                            if (namedString2 != null) {
                                transition.addTarget(namedString2);
                            } else {
                                namedString2 = TypedArrayUtils.getNamedString(obtainStyledAttributes, xmlPullParser, "excludeName", 5);
                                if (namedString2 != null) {
                                    transition.excludeTarget(namedString2, true);
                                } else {
                                    namedString = TypedArrayUtils.getNamedString(obtainStyledAttributes, xmlPullParser, "excludeClass", 3);
                                    if (namedString != null) {
                                        try {
                                            transition.excludeTarget(Class.forName(namedString), true);
                                        } catch (ClassNotFoundException e) {
                                            xmlPullParser = e;
                                        }
                                    } else {
                                        String namedString3 = TypedArrayUtils.getNamedString(obtainStyledAttributes, xmlPullParser, "targetClass", 0);
                                        if (namedString3 != null) {
                                            try {
                                                transition.addTarget(Class.forName(namedString3));
                                            } catch (ClassNotFoundException e2) {
                                                xmlPullParser = e2;
                                                namedString = namedString3;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    obtainStyledAttributes.recycle();
                } else {
                    transition = new StringBuilder("Unknown scene name: ");
                    transition.append(xmlPullParser.getName());
                    throw new RuntimeException(transition.toString());
                }
            }
        }
        obtainStyledAttributes.recycle();
        transition = new StringBuilder("Could not create ");
        transition.append(namedString);
        throw new RuntimeException(transition.toString(), xmlPullParser);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.support.transition.TransitionManager createTransitionManagerFromXml(org.xmlpull.v1.XmlPullParser r5, android.util.AttributeSet r6, android.view.ViewGroup r7) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
        r4 = this;
        r0 = r5.getDepth();
        r1 = 0;
    L_0x0005:
        r2 = r5.next();
        r3 = 3;
        if (r2 != r3) goto L_0x0012;
    L_0x000c:
        r3 = r5.getDepth();
        if (r3 <= r0) goto L_0x0050;
    L_0x0012:
        r3 = 1;
        if (r2 == r3) goto L_0x0050;
    L_0x0015:
        r3 = 2;
        if (r2 != r3) goto L_0x0005;
    L_0x0018:
        r2 = r5.getName();
        r3 = "transitionManager";
        r3 = r2.equals(r3);
        if (r3 == 0) goto L_0x002a;
    L_0x0024:
        r1 = new android.support.transition.TransitionManager;
        r1.<init>();
        goto L_0x0005;
    L_0x002a:
        r3 = "transition";
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x0038;
    L_0x0032:
        if (r1 == 0) goto L_0x0038;
    L_0x0034:
        r4.loadTransition(r6, r5, r7, r1);
        goto L_0x0005;
    L_0x0038:
        r6 = new java.lang.RuntimeException;
        r7 = new java.lang.StringBuilder;
        r0 = "Unknown scene name: ";
        r7.<init>(r0);
        r5 = r5.getName();
        r7.append(r5);
        r5 = r7.toString();
        r6.<init>(r5);
        throw r6;
    L_0x0050:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.transition.TransitionInflater.createTransitionManagerFromXml(org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.view.ViewGroup):android.support.transition.TransitionManager");
    }

    private void loadTransition(AttributeSet attributeSet, XmlPullParser xmlPullParser, ViewGroup viewGroup, TransitionManager transitionManager) throws NotFoundException {
        Scene scene;
        attributeSet = this.mContext.obtainStyledAttributes(attributeSet, Styleable.TRANSITION_MANAGER);
        int namedResourceId = TypedArrayUtils.getNamedResourceId(attributeSet, xmlPullParser, "transition", 2, -1);
        int namedResourceId2 = TypedArrayUtils.getNamedResourceId(attributeSet, xmlPullParser, "fromScene", 0, -1);
        Scene scene2 = null;
        if (namedResourceId2 < 0) {
            scene = null;
        } else {
            scene = Scene.getSceneForLayout(viewGroup, namedResourceId2, this.mContext);
        }
        xmlPullParser = TypedArrayUtils.getNamedResourceId(attributeSet, xmlPullParser, "toScene", 1, -1);
        if (xmlPullParser >= null) {
            scene2 = Scene.getSceneForLayout(viewGroup, xmlPullParser, this.mContext);
        }
        if (namedResourceId >= 0) {
            xmlPullParser = inflateTransition(namedResourceId);
            if (xmlPullParser != null) {
                if (scene2 == null) {
                    xmlPullParser = new StringBuilder("No toScene for transition ID ");
                    xmlPullParser.append(namedResourceId);
                    throw new RuntimeException(xmlPullParser.toString());
                } else if (scene == null) {
                    transitionManager.setTransition(scene2, xmlPullParser);
                } else {
                    transitionManager.setTransition(scene, scene2, xmlPullParser);
                }
            }
        }
        attributeSet.recycle();
    }
}
