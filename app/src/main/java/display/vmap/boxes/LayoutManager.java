package display.vmap.boxes;

import com.xcglobe.xclog.C0101l;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class LayoutManager {
    private static final int ALIGN_ALLOW_CENTER = 4;
    private static final int ALIGN_ALLOW_SCALE_UP = 1;
    private static final int ALIGN_CENTER = 2;
    static int BORDER = C0101l.f578c / 2;
    private static int HEIGHT_INFINITE = 999999;
    private static int MAX_CFG_INFOBOXES_SIZE = 5;
    private static int WIDTH_INFINITE = 999999;
    private static float WIDTH_TOLERANCE_PLUS = 1.05f;
    public int pivotDx;
    public int pivotDy;
    protected float unitSize;
    public int rightPanelWidth = 0;
    public int bottomPanelHeight = 0;
    public int bottomPanelExtendedHeight = 0;
    public boolean bottomPanelNeeded = false;
    private boolean horizontalTerrainMode = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class RowInfo {
        int rightCount = 0;
        int rightSumWidth = 0;
        int leftCount = 0;
        int leftSumWidth = 0;
        int largestWidth = 0;
        int largestWidthIndex = 0;
        int largestHeight = 0;
        int largestHeightIndex = 0;
        int avgWidth = 0;
        int sumWidth = 0;
        int area = 0;
        int topY = 999999;
        int bottomY = -999999;
        int customSizeCount = 0;
        int rowsCount = 0;
        int fullRowsCount = 0;
        int topBottomY = 0;
        int lastRowIndex = 0;

        RowInfo() {
        }
    }

    private void alignRowRight(ArrayList<InfoBox> arrayList, int i2) {
        int size = arrayList.size();
        int i3 = getInfo(arrayList, i2).bottomY;
        for (int i4 = size - 1; i4 >= 0; i4--) {
            InfoBox infoBox = arrayList.get(i4);
            if (!infoBox.customPosition) {
                int width = infoBox.rec.width();
                infoBox.initPosition(i2 - width, i3 - infoBox.rec.height());
                i2 -= width + BORDER;
            }
        }
    }

    private float calcDefaultArea(ArrayList<InfoBox> arrayList, float f2) {
        int size = arrayList.size();
        float f3 = 0.0f;
        for (int i2 = 0; i2 < size; i2++) {
            InfoBox infoBox = arrayList.get(i2);
            if (!infoBox.customPosition) {
                infoBox.initSize(f2);
                f3 += infoBox.rec.width() * infoBox.rec.height();
            }
        }
        return f3;
    }

    private void calcPivot(int i2, int i3) {
        this.pivotDx = 0;
        this.pivotDy = 0;
        int i4 = (i3 / 2) - (i2 / 2);
        double d2 = i3;
        Double.isNaN(d2);
        int i5 = (int) (d2 * 0.4d);
        if (i4 <= i5) {
            i5 = i4;
        }
        this.pivotDy = -i5;
    }

    private void centerRowHorizontally(ArrayList<InfoBox> arrayList, int i2) {
        int size = arrayList.size();
        if (size == 0) {
            return;
        }
        int size2 = (i2 - getInfo(arrayList, i2).sumWidth) / (arrayList.size() + 1);
        int i3 = size2;
        for (int i4 = 0; i4 < size; i4++) {
            InfoBox infoBox = arrayList.get(i4);
            if (!infoBox.customPosition) {
                infoBox.initPosition(i3, infoBox.rec.top);
                i3 += infoBox.rec.width() + size2;
            }
        }
    }

    private void centerVerticaly(ArrayList<InfoBox> arrayList, int i2, int i3, int i4) {
        int i5;
        int i6 = 0;
        int[] iArr = {0};
        int rowsHeight = (i3 - getRowsHeight(arrayList, iArr)) / (iArr[0] + 1);
        int i7 = i4 - rowsHeight;
        while (true) {
            int rowItems = getRowItems(arrayList, i6);
            if (rowItems == 0) {
                return;
            }
            int i8 = i4;
            int i9 = i6;
            while (true) {
                i5 = i6 + rowItems;
                if (i9 < i5) {
                    InfoBox infoBox = arrayList.get(i9);
                    if (!infoBox.customPosition) {
                        infoBox.initPosition(infoBox.rec.left, i7 - infoBox.rec.height());
                        if (infoBox.rec.top < i8) {
                            i8 = infoBox.rec.top;
                        }
                    }
                    i9++;
                }
            }
            // i7 = i8 - rowsHeight;  // unreachable
            // i6 = i5;  // unreachable
        }
    }

    private int createGrid(float f2, ArrayList<InfoBox> arrayList, int i2, int i3, ArrayList<InfoBox> arrayList2, boolean z, boolean z2) {
        int i4;
        boolean z3;
        int i5;
        float f3 = f2;
        int i6 = (int) (i2 * WIDTH_TOLERANCE_PLUS);
        int i7 = -((int) (f3 / 3.0f));
        ArrayList<InfoBox> arrayList3 = new ArrayList<>();
        int i8 = i3;
        int i9 = 0;
        boolean z4 = false;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (i9 < arrayList.size()) {
            InfoBox infoBox = arrayList.get(i9);
            if (infoBox.customPosition || arrayList2.contains(infoBox)) {
                i4 = i6;
            } else {
                infoBox.initSize(f3);
                int width = infoBox.rec.width();
                int height = infoBox.rec.height();
                i4 = i6;
                if (infoBox.customWidth) {
                    z4 = true;
                }
                if (z4) {
                    i5 = i2 - BORDER;
                    z3 = z4;
                } else {
                    z3 = z4;
                    i5 = i4;
                }
                if (i11 + width <= i5) {
                    z4 = z3;
                } else if (width > i5 || (z2 && arrayList3.size() > -1 && width > (i2 * 3) / 4 && i11 < i2 / 2)) {
                    arrayList2.add(infoBox);
                    z4 = z3;
                } else {
                    int realignRow = realignRow(arrayList3, i11, i2, 2);
                    i10 += BORDER + realignRow;
                    arrayList3.clear();
                    z4 = infoBox.customWidth;
                    i8 -= realignRow + BORDER;
                    i11 = 0;
                    i12 = 0;
                }
                int i13 = i8 - height;
                if (i13 < i7) {
                    arrayList2.add(infoBox);
                } else {
                    infoBox.initPosition(i11, i13);
                    arrayList3.add(infoBox);
                    if (height > i12) {
                        i12 = height;
                    }
                    i11 += width + BORDER;
                }
            }
            i9++;
            i6 = i4;
            f3 = f2;
        }
        if (i2 != WIDTH_INFINITE) {
            return i10 + realignRow(arrayList3, i11, i2, z ? 2 : 4) + BORDER;
        }
        return i10;
    }

    private void createGrid(ArrayList<InfoBox> arrayList, int i2, int i3) {
        int i4 = (int) (i2 * WIDTH_TOLERANCE_PLUS);
        ArrayList<InfoBox> arrayList2 = new ArrayList<>();
        int i5 = i3;
        int i6 = 0;
        boolean z = false;
        int i7 = 0;
        for (int i8 = 0; i8 < arrayList.size(); i8++) {
            InfoBox infoBox = arrayList.get(i8);
            if (!infoBox.customPosition) {
                infoBox.initSize(this.unitSize);
                int width = infoBox.rec.width();
                int height = infoBox.rec.height();
                if (infoBox.customWidth) {
                    z = true;
                }
                if (i6 + width > (z ? i2 - BORDER : i4) && arrayList2.size() > 0) {
                    int realignRow = realignRow(arrayList2, i6, i2, 2);
                    arrayList2.clear();
                    z = infoBox.customWidth;
                    i5 -= realignRow + BORDER;
                    i6 = 0;
                    i7 = 0;
                }
                arrayList2.add(infoBox);
                infoBox.initPosition(i6, i5 - height);
                if (height > i7) {
                    i7 = height;
                }
                i6 += width + BORDER;
            }
        }
        if (i2 != WIDTH_INFINITE) {
            realignRow(arrayList2, i6, i2, 4);
        }
    }

    private void createLandscape(ArrayList<InfoBox> arrayList, int i2, int i3) {
        int size = arrayList.size();
        if (size == 0) {
            return;
        }
        createGrid(arrayList, WIDTH_INFINITE, i3);
        RowInfo info = getInfo(arrayList, i2);
        int i4 = (int) ((i2 * 1.1f) / 2.0f);
        double d2 = ((int) (size * (this.unitSize + BORDER))) / i3;
        Double.isNaN(d2);
        int i5 = info.avgWidth * ((int) (d2 + 0.7d));
        ArrayList<InfoBox> arrayList2 = new ArrayList<>();
        float f2 = 999.0f;
        int i6 = (i4 - 1) / 8;
        int i7 = 1;
        int i8 = 1;
        int i9 = 0;
        boolean z = false;
        while (i9 < 2) {
            float f3 = f2;
            boolean z2 = z;
            int i10 = i8;
            int i11 = 1;
            while (i11 <= i4) {
                arrayList2.clear();
                int i12 = i11;
                int i13 = i4;
                int i14 = i9;
                createGrid(this.unitSize, arrayList, i11, i3, arrayList2, true, i9 == i7);
                int i15 = getInfo(arrayList, i2).area - getInfo(arrayList2, i2).area;
                float f4 = i15 / (i12 * i3);
                if (i15 == 0) {
                    f4 = 0.7f;
                }
                float abs = Math.abs(1.0f - f4);
                int size2 = arrayList2.size();
                float f5 = abs + (((size2 / 3) + (size2 / 20.0f)) / 6.0f);
                if (size2 > (size + 1) / 2 && size > 3) {
                    f5 += 1.0f;
                }
                if (f5 < f3) {
                    z2 = i14 == 1;
                    f3 = f5;
                    i10 = i12;
                }
                i11 = i12 + i6;
                i9 = i14;
                i4 = i13;
                i7 = 1;
            }
            i9++;
            i8 = i10;
            z = z2;
            f2 = f3;
            i4 = i4;
            i7 = 1;
        }
        arrayList2.clear();
        int i16 = i8;
        createGrid(this.unitSize, arrayList, i8, i3, arrayList2, true, z);
        ArrayList<InfoBox> excludeBoxes = excludeBoxes(arrayList, arrayList2);
        centerVerticaly(excludeBoxes, i16, i3, i3);
        moveBoxes(excludeBoxes, i2 - i16, 0);
        for (int i17 = 0; i17 < excludeBoxes.size(); i17++) {
            excludeBoxes.get(i17).docked = true;
        }
        if (i16 == 1) {
            i16 = 0;
        }
        this.rightPanelWidth = i16;
        int i18 = i2 - i16;
        if (i16 > 0) {
            i18 -= BORDER;
        }
        createPortrait(arrayList2, i18, i3, false);
        for (int i19 = 0; i19 < arrayList2.size(); i19++) {
            arrayList2.get(i19).docked = false;
        }
    }

    private void createPortrait(ArrayList<InfoBox> arrayList, int i2, int i3, boolean z) {
        if (arrayList.size() == 0) {
            return;
        }
        ArrayList<InfoBox> arrayList2 = new ArrayList<>();
        createGrid(this.unitSize, arrayList, i2, i3, arrayList2, false, false);
        if (arrayList2.size() > 0) {
            ArrayList<InfoBox> excludeBoxes = excludeBoxes(arrayList, arrayList2);
            createGrid(arrayList2, i2, i3);
            if (z) {
                shiftRejected(arrayList, arrayList2);
                reorderBoxes(arrayList);
            } else {
                moveBoxes(excludeBoxes, 0, -((i3 - getTopBoxY(arrayList2, i2, i3, false)) + BORDER));
                arrayList2.addAll(excludeBoxes);
                arrayList = arrayList2;
            }
        }
        int topBoxY = getTopBoxY(arrayList, i2, i3, true);
        this.bottomPanelHeight = (i3 - topBoxY) + BORDER;
        RowInfo info = getInfo(arrayList, i2);
        this.bottomPanelNeeded = info.fullRowsCount > 1 && this.bottomPanelHeight > 0;
        if (this.bottomPanelNeeded && info.rowsCount > info.fullRowsCount) {
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                InfoBox infoBox = arrayList.get(i4);
                if (!infoBox.customPosition && infoBox.rec.bottom == info.topBottomY) {
                    infoBox.initPosition(infoBox.rec.left, infoBox.rec.top - BORDER);
                }
            }
        }
        if (this.bottomPanelNeeded) {
            for (int i5 = 0; i5 < arrayList.size(); i5++) {
                InfoBox infoBox2 = arrayList.get(i5);
                if (!infoBox2.customPosition && infoBox2.rec.top > i3 - this.bottomPanelHeight) {
                    infoBox2.docked = true;
                }
            }
        }
        this.bottomPanelExtendedHeight = i3 - getTopBoxY(arrayList, i2, i3, false);
        if (this.bottomPanelNeeded) {
            return;
        }
        calcPivot(topBoxY, i3);
    }

    private float createUnitSize(int i2) {
        return (i2 + 3.0f) * C0101l.f578c;
    }

    private ArrayList<InfoBox> excludeBoxes(ArrayList<InfoBox> arrayList, ArrayList<InfoBox> arrayList2) {
        ArrayList<InfoBox> arrayList3 = new ArrayList<>();
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            InfoBox infoBox = arrayList.get(i2);
            if (!arrayList2.contains(infoBox)) {
                arrayList3.add(infoBox);
            }
        }
        return arrayList3;
    }

    private int findBottomBox(ArrayList<InfoBox> arrayList) {
        int i2 = -1;
        int i3 = 0;
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            InfoBox infoBox = arrayList.get(i4);
            if (infoBox != null && !infoBox.customPosition && infoBox.rec.bottom > i3) {
                i3 = infoBox.rec.bottom;
                i2 = i4;
            }
        }
        return i2;
    }

    private RowInfo getInfo(ArrayList<InfoBox> arrayList, int i2) {
        return getInfo(arrayList, 0, arrayList.size(), i2);
    }

    private RowInfo getInfo(ArrayList<InfoBox> arrayList, int i2, int i3, int i4) {
        RowInfo rowInfo = new RowInfo();
        int i5 = i2 + i3;
        if (i5 <= arrayList.size() && i3 >= 1) {
            int i6 = 99999;
            int i7 = i4 / 2;
            InfoBox infoBox = null;
            int i8 = 0;
            while (i2 < i5) {
                InfoBox infoBox2 = arrayList.get(i2);
                if (!infoBox2.customPosition) {
                    if (infoBox2.customWidth) {
                        rowInfo.customSizeCount++;
                    }
                    if (infoBox2.rec.top < rowInfo.topY) {
                        rowInfo.topY = infoBox2.rec.top;
                    }
                    if (infoBox2.rec.bottom > rowInfo.bottomY) {
                        rowInfo.bottomY = infoBox2.rec.bottom;
                    }
                    if (infoBox2.rec.bottom != i6) {
                        rowInfo.rowsCount++;
                        i6 = infoBox2.rec.bottom;
                        rowInfo.lastRowIndex = i2;
                    }
                    int width = infoBox2.rec.width();
                    int height = infoBox2.rec.height();
                    rowInfo.area += width * height;
                    if (infoBox2.rec.left >= i7) {
                        rowInfo.rightCount++;
                        rowInfo.rightSumWidth += width;
                    } else {
                        rowInfo.leftCount++;
                        rowInfo.leftSumWidth += width;
                    }
                    if (width > rowInfo.largestWidth) {
                        rowInfo.largestWidth = width;
                        rowInfo.largestWidthIndex = i2;
                    }
                    if (height > rowInfo.largestHeight) {
                        rowInfo.largestHeight = height;
                        rowInfo.largestHeightIndex = i2;
                    }
                    i8 += width;
                    infoBox = infoBox2;
                }
                i2++;
            }
            rowInfo.fullRowsCount = (infoBox == null || isFullRow(getRowWidth(arrayList, rowInfo.lastRowIndex), i4)) ? rowInfo.rowsCount : rowInfo.rowsCount - 1;
            rowInfo.topBottomY = infoBox != null ? infoBox.rec.bottom : 0;
            rowInfo.sumWidth = i8;
            rowInfo.avgWidth = i8 / arrayList.size();
            if (rowInfo.rightCount > 0) {
                rowInfo.rightSumWidth += BORDER * (rowInfo.rightCount - 1);
            }
            if (rowInfo.leftCount > 0) {
                rowInfo.leftSumWidth += BORDER * (rowInfo.leftCount - 1);
            }
        }
        return rowInfo;
    }

    private int getRowItems(ArrayList<InfoBox> arrayList, int i2) {
        int size = arrayList.size();
        while (i2 < size && arrayList.get(i2).customPosition) {
            i2++;
        }
        int i3 = 0;
        if (i2 >= size) {
            return 0;
        }
        int i4 = arrayList.get(i2).rec.bottom;
        while (i2 < size) {
            InfoBox infoBox = arrayList.get(i2);
            if (!infoBox.customPosition && infoBox.rec.bottom != i4) {
                break;
            }
            i3++;
            i2++;
        }
        return i3;
    }

    private int getRowWidth(ArrayList<InfoBox> arrayList, int i2) {
        int size = arrayList.size();
        int i3 = arrayList.get(i2).rec.bottom;
        int i4 = 0;
        while (i2 < size) {
            InfoBox infoBox = arrayList.get(i2);
            if (!infoBox.customPosition) {
                if (infoBox.rec.bottom != i3) {
                    break;
                }
                i4 += infoBox.rec.width();
            }
            i2++;
        }
        return i4;
    }

    private int getRowsHeight(ArrayList<InfoBox> arrayList, int[] iArr) {
        int i2 = 0;
        int i3 = 0;
        int i4 = 99999;
        int i5 = 0;
        while (true) {
            int rowItems = getRowItems(arrayList, i2);
            if (rowItems == 0) {
                break;
            }
            RowInfo info = getInfo(arrayList, i2, rowItems, WIDTH_INFINITE);
            i3 += info.bottomY - info.topY;
            if (info.bottomY <= i4) {
                i4 = info.topY;
                i5++;
            }
            i2 += rowItems;
        }
        if (iArr != null) {
            iArr[0] = i5;
        }
        return i3;
    }

    private int getTopBoxY(ArrayList<InfoBox> arrayList, int i2, int i3, boolean z) {
        int size = arrayList.size();
        if (size == 0) {
            return i3;
        }
        int i4 = HEIGHT_INFINITE;
        int i5 = HEIGHT_INFINITE;
        boolean z2 = false;
        int i6 = 0;
        for (int i7 = size - 1; i7 >= 0; i7--) {
            InfoBox infoBox = arrayList.get(i7);
            if (!infoBox.customPosition) {
                if (i4 == HEIGHT_INFINITE) {
                    i4 = infoBox.rec.bottom;
                }
                if (infoBox.rec.bottom != i4) {
                    if (!z || z2) {
                        return i5;
                    }
                    i5 = infoBox.rec.top;
                    i4 = infoBox.rec.bottom;
                    z2 = true;
                    i6 = 0;
                }
                i6 += infoBox.rec.width();
                if (!z2 && isFullRow(i6, i2)) {
                    z2 = true;
                }
                if (infoBox.rec.top < i5 && (!z || z2)) {
                    i5 = infoBox.rec.top;
                }
            }
        }
        return i5 == HEIGHT_INFINITE ? i3 : i5;
    }

    private boolean isFullRow(int i2, int i3) {
        return i2 > (i3 * 7) / 12;
    }

    private boolean isHorizontalTerrainNeeded(ArrayList<InfoBox> arrayList) {
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            InfoBox infoBox = arrayList.get(i2);
            boolean hasCustomPosition = infoBox.hasCustomPosition();
            InfoBox visibleBox = infoBox.getVisibleBox();
            if (hasCustomPosition && visibleBox.getClass() == BoxGroundProfile.class && !BoxGroundProfile.disabled) {
                return true;
            }
        }
        return false;
    }

    private void moveBoxes(int i2, ArrayList<InfoBox> arrayList, int i3, int i4, ArrayList<InfoBox> arrayList2, int i5) {
        while (i2 < arrayList.size()) {
            InfoBox infoBox = arrayList.get(i2);
            if (!infoBox.customPosition && infoBox.rec.bottom < i5 && arrayList2.indexOf(infoBox) == -1) {
                infoBox.initPosition(infoBox.rec.left + i3, infoBox.rec.top + i4);
            }
            i2++;
        }
    }

    private void moveBoxes(ArrayList<InfoBox> arrayList, int i2, int i3) {
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            InfoBox infoBox = arrayList.get(i4);
            if (!infoBox.customPosition) {
                infoBox.initPosition(infoBox.rec.left + i2, infoBox.rec.top + i3);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:64:0x00fb, code lost:
    
        if (r9 != false) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int realignRow(ArrayList<InfoBox> arrayList, int i2, int i3, int i4) {
        int i5 = 0;
        int i6 = i3;
        if (i6 == WIDTH_INFINITE && (i4 & 1) != 0) {
            i6 = 0;
        }
        int size = arrayList.size();
        if (size == 0) {
            return 0;
        }
        int height = arrayList.get(0).rec.height();
        float f2 = i6 / i2;
        boolean z = (i4 & 2) != 0;
        if ((i4 & 4) != 0) {
            double d2 = i2;
            double d3 = i6;
            Double.isNaN(d3);
            if (d2 > d3 * 0.75d) {
                z = true;
            }
        }
        if (f2 > 1.0f) {
            if ((i4 & 1) != 0) {
                float size2 = (i6 - i2) / (arrayList.size() + 1);
                float f3 = size2;
                while (i5 < arrayList.size()) {
                    InfoBox infoBox = arrayList.get(i5);
                    if (!infoBox.customPosition) {
                        infoBox.initPosition((int) f3, infoBox.rec.top);
                        f3 += infoBox.rec.width() + size2;
                        height = infoBox.rec.height();
                    }
                    i5++;
                }
            } else {
                height = getInfo(arrayList, WIDTH_INFINITE).largestHeight;
                if (!z) {
                    if (this.horizontalTerrainMode) {
                        alignRowRight(arrayList, i6);
                    } else if (size == 1 || i2 < i6 / 2) {
                        int i7 = BORDER - arrayList.get(0).rec.left;
                        if (i7 > 0 && i2 < i6 - (BORDER * 2)) {
                            moveBoxes(arrayList, i7, 0);
                        }
                    } else {
                        splitRow(arrayList, i6);
                    }
                }
                centerRowHorizontally(arrayList, i6);
            }
        } else if (f2 < 1.0f) {
            int i8 = 0;
            height = 0;
            while (i5 < arrayList.size()) {
                InfoBox infoBox2 = arrayList.get(i5);
                if (!infoBox2.customPosition) {
                    int i9 = infoBox2.rec.bottom;
                    infoBox2.initSize(infoBox2.unitSize * f2);
                    int width = infoBox2.rec.width();
                    int height2 = infoBox2.rec.height();
                    infoBox2.initPosition(i8, i9 - height2);
                    i8 += width + BORDER;
                    if (height2 > height) {
                        height = height2;
                    }
                }
                i5++;
            }
        }
        return height;
    }

    private void reorderBoxes(ArrayList<InfoBox> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        while (true) {
            int findBottomBox = findBottomBox(arrayList);
            if (findBottomBox == -1) {
                break;
            }
            arrayList2.add(arrayList.get(findBottomBox));
            arrayList.set(findBottomBox, null);
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            InfoBox infoBox = arrayList.get(i2);
            if (infoBox != null) {
                arrayList2.add(infoBox);
            }
        }
        arrayList.clear();
        arrayList.addAll(arrayList2);
    }

    private void sanitize(ArrayList<InfoBox> arrayList, int i2, int i3) {
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            InfoBox infoBox = arrayList.get(i4);
            if (!infoBox.customPosition && (infoBox.rec.left < 0 || infoBox.rec.left >= i2 || infoBox.rec.bottom < 0 || infoBox.rec.top > i3)) {
                infoBox.initPosition(0, 0);
            }
        }
    }

    private void shiftRejected(ArrayList<InfoBox> arrayList, ArrayList<InfoBox> arrayList2) {
        int i2 = -1;
        int i3 = -1;
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            InfoBox infoBox = arrayList.get(i4);
            if (!infoBox.customPosition) {
                if (i2 == -1) {
                    i2 = infoBox.rec.bottom;
                }
                if (arrayList2.indexOf(infoBox) != -1) {
                    infoBox.initPosition(infoBox.rec.left, i2 - infoBox.rec.height());
                    moveBoxes(i4 + 1, arrayList, 0, -(infoBox.rec.height() + BORDER), arrayList2, i3 == -1 ? 9999999 : i3);
                } else {
                    i3 = infoBox.rec.bottom;
                }
                i2 = infoBox.rec.top - BORDER;
            }
        }
    }

    private void splitRow(ArrayList<InfoBox> arrayList, int i2) {
        int size = arrayList.size();
        if (size < 2) {
            return;
        }
        RowInfo info = getInfo(arrayList, i2);
        int i3 = info.bottomY;
        int i4 = info.rightCount;
        if (i4 == 0 && size > 1) {
            i4 = 1;
        }
        for (int i5 = 0; i5 < i4; i5++) {
            InfoBox infoBox = arrayList.get((size - 1) - i5);
            if (!infoBox.customPosition) {
                int width = infoBox.rec.width();
                infoBox.initPosition(i2 - width, i3 - infoBox.rec.height());
                i2 -= width + BORDER;
            }
        }
    }

    public void create(ArrayList<InfoBox> arrayList, int i2, int i3) {
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            arrayList.get(i4).onLayoutStart();
        }
        this.horizontalTerrainMode = isHorizontalTerrainNeeded(arrayList);
        float f2 = i2 * i3 * 0.75f;
        float calcDefaultArea = calcDefaultArea(arrayList, createUnitSize(MAX_CFG_INFOBOXES_SIZE));
        float f3 = calcDefaultArea > f2 ? f2 / calcDefaultArea : 1.0f;
        this.unitSize = createUnitSize(C0101l.f561ak);
        this.unitSize *= f3;
        if (i2 > i3) {
            createLandscape(arrayList, i2, i3);
        } else {
            createPortrait(arrayList, i2, i3, true);
        }
        sanitize(arrayList, i2, i3);
        int i5 = 0;
        boolean z = true;
        while (i5 < arrayList.size()) {
            InfoBox infoBox = arrayList.get(i5);
            if (!infoBox.customPosition) {
                infoBox.isRightmost = true;
                infoBox.isBottommost = true;
            }
            int i6 = i5 + 1;
            int i7 = i6;
            while (true) {
                if (i7 < arrayList.size()) {
                    InfoBox infoBox2 = arrayList.get(i7);
                    if (infoBox2.customPosition) {
                        i7++;
                    } else {
                        if (infoBox2.rec.left >= infoBox.rec.right) {
                            infoBox.isRightmost = false;
                        }
                        if (infoBox2.rec.bottom <= infoBox.rec.top) {
                            z = false;
                        }
                    }
                }
            }
            // infoBox.isBottommost = z;  // unreachable
            // arrayList.get(i5).onPosition();  // unreachable
            // i5 = i6;  // unreachable
        }
    }

    public void finalize(ArrayList<InfoBox> arrayList) {
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            arrayList.get(i2).onFinalized(this);
        }
    }

    public boolean isHorizontalTerrainMode() {
        return this.horizontalTerrainMode;
    }
}
