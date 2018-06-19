package android.support.v7.widget;

import java.util.List;

class OpReorderer {
    final Callback mCallback;

    interface Callback {
        UpdateOp obtainUpdateOp(int i, int i2, int i3, Object obj);

        void recycleUpdateOp(UpdateOp updateOp);
    }

    OpReorderer(Callback callback) {
        this.mCallback = callback;
    }

    void reorderOps(List<UpdateOp> list) {
        while (true) {
            int lastMoveOutOfOrder = getLastMoveOutOfOrder(list);
            if (lastMoveOutOfOrder != -1) {
                swapMoveOp(list, lastMoveOutOfOrder, lastMoveOutOfOrder + 1);
            } else {
                return;
            }
        }
    }

    private void swapMoveOp(List<UpdateOp> list, int i, int i2) {
        UpdateOp updateOp = (UpdateOp) list.get(i);
        UpdateOp updateOp2 = (UpdateOp) list.get(i2);
        int i3 = updateOp2.cmd;
        if (i3 != 4) {
            switch (i3) {
                case 1:
                    swapMoveAdd(list, i, updateOp, i2, updateOp2);
                    return;
                case 2:
                    swapMoveRemove(list, i, updateOp, i2, updateOp2);
                    return;
                default:
                    break;
            }
        }
        swapMoveUpdate(list, i, updateOp, i2, updateOp2);
    }

    void swapMoveRemove(List<UpdateOp> list, int i, UpdateOp updateOp, int i2, UpdateOp updateOp2) {
        int i3;
        int i4 = 0;
        if (updateOp.positionStart < updateOp.itemCount) {
            if (updateOp2.positionStart == updateOp.positionStart && updateOp2.itemCount == updateOp.itemCount - updateOp.positionStart) {
                i3 = 0;
                i4 = 1;
            } else {
                i3 = 0;
            }
        } else if (updateOp2.positionStart == updateOp.itemCount + 1 && updateOp2.itemCount == updateOp.positionStart - updateOp.itemCount) {
            i3 = 1;
            i4 = i3;
        } else {
            i3 = 1;
        }
        if (updateOp.itemCount < updateOp2.positionStart) {
            updateOp2.positionStart--;
        } else if (updateOp.itemCount < updateOp2.positionStart + updateOp2.itemCount) {
            updateOp2.itemCount--;
            updateOp.cmd = 2;
            updateOp.itemCount = 1;
            if (updateOp2.itemCount == 0) {
                list.remove(i2);
                this.mCallback.recycleUpdateOp(updateOp2);
            }
            return;
        }
        UpdateOp updateOp3 = null;
        if (updateOp.positionStart <= updateOp2.positionStart) {
            updateOp2.positionStart++;
        } else if (updateOp.positionStart < updateOp2.positionStart + updateOp2.itemCount) {
            updateOp3 = this.mCallback.obtainUpdateOp(2, updateOp.positionStart + 1, (updateOp2.positionStart + updateOp2.itemCount) - updateOp.positionStart, null);
            updateOp2.itemCount = updateOp.positionStart - updateOp2.positionStart;
        }
        if (i4 != 0) {
            list.set(i, updateOp2);
            list.remove(i2);
            this.mCallback.recycleUpdateOp(updateOp);
            return;
        }
        if (i3 != 0) {
            if (updateOp3 != null) {
                if (updateOp.positionStart > updateOp3.positionStart) {
                    updateOp.positionStart -= updateOp3.itemCount;
                }
                if (updateOp.itemCount > updateOp3.positionStart) {
                    updateOp.itemCount -= updateOp3.itemCount;
                }
            }
            if (updateOp.positionStart > updateOp2.positionStart) {
                updateOp.positionStart -= updateOp2.itemCount;
            }
            if (updateOp.itemCount > updateOp2.positionStart) {
                updateOp.itemCount -= updateOp2.itemCount;
            }
        } else {
            if (updateOp3 != null) {
                if (updateOp.positionStart >= updateOp3.positionStart) {
                    updateOp.positionStart -= updateOp3.itemCount;
                }
                if (updateOp.itemCount >= updateOp3.positionStart) {
                    updateOp.itemCount -= updateOp3.itemCount;
                }
            }
            if (updateOp.positionStart >= updateOp2.positionStart) {
                updateOp.positionStart -= updateOp2.itemCount;
            }
            if (updateOp.itemCount >= updateOp2.positionStart) {
                updateOp.itemCount -= updateOp2.itemCount;
            }
        }
        list.set(i, updateOp2);
        if (updateOp.positionStart != updateOp.itemCount) {
            list.set(i2, updateOp);
        } else {
            list.remove(i2);
        }
        if (updateOp3 != null) {
            list.add(i, updateOp3);
        }
    }

    private void swapMoveAdd(List<UpdateOp> list, int i, UpdateOp updateOp, int i2, UpdateOp updateOp2) {
        int i3 = updateOp.itemCount < updateOp2.positionStart ? -1 : 0;
        if (updateOp.positionStart < updateOp2.positionStart) {
            i3++;
        }
        if (updateOp2.positionStart <= updateOp.positionStart) {
            updateOp.positionStart += updateOp2.itemCount;
        }
        if (updateOp2.positionStart <= updateOp.itemCount) {
            updateOp.itemCount += updateOp2.itemCount;
        }
        updateOp2.positionStart += i3;
        list.set(i, updateOp2);
        list.set(i2, updateOp);
    }

    void swapMoveUpdate(List<UpdateOp> list, int i, UpdateOp updateOp, int i2, UpdateOp updateOp2) {
        Object obtainUpdateOp;
        Object obj = null;
        if (updateOp.itemCount < updateOp2.positionStart) {
            updateOp2.positionStart--;
        } else if (updateOp.itemCount < updateOp2.positionStart + updateOp2.itemCount) {
            updateOp2.itemCount--;
            obtainUpdateOp = this.mCallback.obtainUpdateOp(4, updateOp.positionStart, 1, updateOp2.payload);
            if (updateOp.positionStart <= updateOp2.positionStart) {
                updateOp2.positionStart++;
            } else if (updateOp.positionStart < updateOp2.positionStart + updateOp2.itemCount) {
                int i3 = (updateOp2.positionStart + updateOp2.itemCount) - updateOp.positionStart;
                obj = this.mCallback.obtainUpdateOp(4, updateOp.positionStart + 1, i3, updateOp2.payload);
                updateOp2.itemCount -= i3;
            }
            list.set(i2, updateOp);
            if (updateOp2.itemCount <= null) {
                list.set(i, updateOp2);
            } else {
                list.remove(i);
                this.mCallback.recycleUpdateOp(updateOp2);
            }
            if (obtainUpdateOp != null) {
                list.add(i, obtainUpdateOp);
            }
            if (obj != null) {
                list.add(i, obj);
            }
        }
        obtainUpdateOp = null;
        if (updateOp.positionStart <= updateOp2.positionStart) {
            updateOp2.positionStart++;
        } else if (updateOp.positionStart < updateOp2.positionStart + updateOp2.itemCount) {
            int i32 = (updateOp2.positionStart + updateOp2.itemCount) - updateOp.positionStart;
            obj = this.mCallback.obtainUpdateOp(4, updateOp.positionStart + 1, i32, updateOp2.payload);
            updateOp2.itemCount -= i32;
        }
        list.set(i2, updateOp);
        if (updateOp2.itemCount <= null) {
            list.remove(i);
            this.mCallback.recycleUpdateOp(updateOp2);
        } else {
            list.set(i, updateOp2);
        }
        if (obtainUpdateOp != null) {
            list.add(i, obtainUpdateOp);
        }
        if (obj != null) {
            list.add(i, obj);
        }
    }

    private int getLastMoveOutOfOrder(List<UpdateOp> list) {
        int i = 0;
        for (int size = list.size() - 1; size >= 0; size--) {
            if (((UpdateOp) list.get(size)).cmd != 8) {
                i = 1;
            } else if (i != 0) {
                return size;
            }
        }
        return -1;
    }
}
