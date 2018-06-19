package android.support.transition;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class TransitionManager {
    private static final String LOG_TAG = "TransitionManager";
    private static Transition sDefaultTransition = new AutoTransition();
    private static ArrayList<ViewGroup> sPendingTransitions = new ArrayList();
    private static ThreadLocal<WeakReference<ArrayMap<ViewGroup, ArrayList<Transition>>>> sRunningTransitions = new ThreadLocal();
    private ArrayMap<Scene, ArrayMap<Scene, Transition>> mScenePairTransitions = new ArrayMap();
    private ArrayMap<Scene, Transition> mSceneTransitions = new ArrayMap();

    private static class MultiListener implements OnAttachStateChangeListener, OnPreDrawListener {
        ViewGroup mSceneRoot;
        Transition mTransition;

        public void onViewAttachedToWindow(View view) {
        }

        MultiListener(Transition transition, ViewGroup viewGroup) {
            this.mTransition = transition;
            this.mSceneRoot = viewGroup;
        }

        private void removeListeners() {
            this.mSceneRoot.getViewTreeObserver().removeOnPreDrawListener(this);
            this.mSceneRoot.removeOnAttachStateChangeListener(this);
        }

        public void onViewDetachedFromWindow(View view) {
            removeListeners();
            TransitionManager.sPendingTransitions.remove(this.mSceneRoot);
            ArrayList arrayList = (ArrayList) TransitionManager.getRunningTransitions().get(this.mSceneRoot);
            if (arrayList != null && arrayList.size() > 0) {
                view = arrayList.iterator();
                while (view.hasNext()) {
                    ((Transition) view.next()).resume(this.mSceneRoot);
                }
            }
            this.mTransition.clearValues(true);
        }

        public boolean onPreDraw() {
            removeListeners();
            if (!TransitionManager.sPendingTransitions.remove(this.mSceneRoot)) {
                return true;
            }
            final ArrayMap runningTransitions = TransitionManager.getRunningTransitions();
            ArrayList arrayList = (ArrayList) runningTransitions.get(this.mSceneRoot);
            ArrayList arrayList2 = null;
            if (arrayList == null) {
                arrayList = new ArrayList();
                runningTransitions.put(this.mSceneRoot, arrayList);
            } else if (arrayList.size() > 0) {
                arrayList2 = new ArrayList(arrayList);
            }
            arrayList.add(this.mTransition);
            this.mTransition.addListener(new TransitionListenerAdapter() {
                public void onTransitionEnd(@NonNull Transition transition) {
                    ((ArrayList) runningTransitions.get(MultiListener.this.mSceneRoot)).remove(transition);
                }
            });
            this.mTransition.captureValues(this.mSceneRoot, false);
            if (arrayList2 != null) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((Transition) it.next()).resume(this.mSceneRoot);
                }
            }
            this.mTransition.playTransition(this.mSceneRoot);
            return true;
        }
    }

    public void setTransition(@NonNull Scene scene, @Nullable Transition transition) {
        this.mSceneTransitions.put(scene, transition);
    }

    public void setTransition(@NonNull Scene scene, @NonNull Scene scene2, @Nullable Transition transition) {
        ArrayMap arrayMap = (ArrayMap) this.mScenePairTransitions.get(scene2);
        if (arrayMap == null) {
            arrayMap = new ArrayMap();
            this.mScenePairTransitions.put(scene2, arrayMap);
        }
        arrayMap.put(scene, transition);
    }

    private Transition getTransition(Scene scene) {
        View sceneRoot = scene.getSceneRoot();
        if (sceneRoot != null) {
            Scene currentScene = Scene.getCurrentScene(sceneRoot);
            if (currentScene != null) {
                ArrayMap arrayMap = (ArrayMap) this.mScenePairTransitions.get(scene);
                if (arrayMap != null) {
                    Transition transition = (Transition) arrayMap.get(currentScene);
                    if (transition != null) {
                        return transition;
                    }
                }
            }
        }
        Transition transition2 = (Transition) this.mSceneTransitions.get(scene);
        if (transition2 != null) {
            return transition2;
        }
        return sDefaultTransition;
    }

    private static void changeScene(Scene scene, Transition transition) {
        View sceneRoot = scene.getSceneRoot();
        if (!sPendingTransitions.contains(sceneRoot)) {
            if (transition == null) {
                scene.enter();
                return;
            }
            sPendingTransitions.add(sceneRoot);
            transition = transition.clone();
            transition.setSceneRoot(sceneRoot);
            Scene currentScene = Scene.getCurrentScene(sceneRoot);
            if (currentScene != null && currentScene.isCreatedFromLayoutResource()) {
                transition.setCanRemoveViews(true);
            }
            sceneChangeSetup(sceneRoot, transition);
            scene.enter();
            sceneChangeRunTransition(sceneRoot, transition);
        }
    }

    static ArrayMap<ViewGroup, ArrayList<Transition>> getRunningTransitions() {
        WeakReference weakReference = (WeakReference) sRunningTransitions.get();
        if (weakReference == null || weakReference.get() == null) {
            WeakReference weakReference2 = new WeakReference(new ArrayMap());
            sRunningTransitions.set(weakReference2);
            weakReference = weakReference2;
        }
        return (ArrayMap) weakReference.get();
    }

    private static void sceneChangeRunTransition(ViewGroup viewGroup, Transition transition) {
        if (transition != null && viewGroup != null) {
            Object multiListener = new MultiListener(transition, viewGroup);
            viewGroup.addOnAttachStateChangeListener(multiListener);
            viewGroup.getViewTreeObserver().addOnPreDrawListener(multiListener);
        }
    }

    private static void sceneChangeSetup(ViewGroup viewGroup, Transition transition) {
        ArrayList arrayList = (ArrayList) getRunningTransitions().get(viewGroup);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((Transition) it.next()).pause(viewGroup);
            }
        }
        if (transition != null) {
            transition.captureValues(viewGroup, true);
        }
        viewGroup = Scene.getCurrentScene(viewGroup);
        if (viewGroup != null) {
            viewGroup.exit();
        }
    }

    public void transitionTo(@NonNull Scene scene) {
        changeScene(scene, getTransition(scene));
    }

    public static void go(@NonNull Scene scene) {
        changeScene(scene, sDefaultTransition);
    }

    public static void go(@NonNull Scene scene, @Nullable Transition transition) {
        changeScene(scene, transition);
    }

    public static void beginDelayedTransition(@NonNull ViewGroup viewGroup) {
        beginDelayedTransition(viewGroup, null);
    }

    public static void beginDelayedTransition(@NonNull ViewGroup viewGroup, @Nullable Transition transition) {
        if (!sPendingTransitions.contains(viewGroup) && ViewCompat.isLaidOut(viewGroup)) {
            sPendingTransitions.add(viewGroup);
            if (transition == null) {
                transition = sDefaultTransition;
            }
            transition = transition.clone();
            sceneChangeSetup(viewGroup, transition);
            Scene.setCurrentScene(viewGroup, null);
            sceneChangeRunTransition(viewGroup, transition);
        }
    }

    public static void endTransitions(ViewGroup viewGroup) {
        sPendingTransitions.remove(viewGroup);
        ArrayList arrayList = (ArrayList) getRunningTransitions().get(viewGroup);
        if (arrayList != null && !arrayList.isEmpty()) {
            ArrayList arrayList2 = new ArrayList(arrayList);
            for (int size = arrayList2.size() - 1; size >= 0; size--) {
                ((Transition) arrayList2.get(size)).forceToEnd(viewGroup);
            }
        }
    }
}
