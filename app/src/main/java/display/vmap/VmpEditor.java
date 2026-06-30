package display.vmap;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.util.SparseBooleanArray;
import com.xcglobe.flyme.R;
import com.xcglobe.xclog.App;
import com.xcglobe.xclog.C0099j;
import display.vmap.boxes.BoxSet;
import display.vmap.boxes.InfoBox;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class VmpEditor {
    String boxClassPrefix;
    ViewVmp view;
    private String[] boxClassNames = {"BoxVario", "BoxAltitude", "BoxSpeed", "BoxWind", "BoxGroundProfile", "BoxGoal", "BoxAirspace", "BoxAirspaceInfo", "BoxNearThermal", "BoxOlcScore", "BoxCompetitionTask", "BoxAgl", "BoxGroundElev", "BoxSpeedCircle", "BoxFinesse", "BoxHeading", "BoxGlideToGoal"};
    private int[] boxTitles = {R.string.box_vario, R.string.box_msl, R.string.box_speed, R.string.box_wind, R.string.box_ground, R.string.goal, R.string.box_air_violation, R.string.box_air_info, R.string.box_thermal, R.string.olc_score, R.string.competition_task, R.string.box_agl, R.string.elevation, R.string.speed_circle, R.string.finesse, R.string.heading, R.string.glide_to_goal};

    public VmpEditor(ViewVmp viewVmp) {
        this.view = viewVmp;
        String name = InfoBox.class.getName();
        int lastIndexOf = name.lastIndexOf(46);
        this.boxClassPrefix = lastIndexOf != -1 ? name.substring(0, lastIndexOf + 1) : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeBox(InfoBox infoBox, String[] strArr) {
        InfoBox infoBox2;
        int length = strArr.length;
        int indexOf = this.view.boxes.indexOf(infoBox);
        if (length == 0) {
            if (indexOf != -1) {
                this.view.boxes.remove(infoBox);
            }
            infoBox2 = null;
        } else {
            if (length == 1) {
                infoBox2 = createBox(strArr[0]);
            } else {
                BoxSet boxSet = new BoxSet();
                for (String str : strArr) {
                    InfoBox createBox = createBox(str);
                    if (createBox != null) {
                        boxSet.add(createBox);
                    }
                }
                infoBox2 = boxSet;
            }
        }
        if (infoBox2 != null) {
            if (indexOf != -1) {
                this.view.boxes.set(indexOf, infoBox2);
            } else {
                this.view.boxes.add(infoBox2);
            }
        }
        C0099j.m527d("boxes", saveBoxes(this.view.boxes));
        this.view.initDisplay();
    }

    private InfoBox createBox(String str) {
        try {
            return (InfoBox) Class.forName(this.boxClassPrefix + str).getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private boolean[] getSelected(String[] strArr, InfoBox infoBox) {
        int length = strArr.length;
        boolean[] zArr = new boolean[length];
        if (infoBox == null) {
            return zArr;
        }
        String simpleName = infoBox.getClass().getSimpleName();
        for (int i2 = 0; i2 < length; i2++) {
            if (infoBox instanceof BoxSet) {
                BoxSet boxSet = (BoxSet) infoBox;
                int i3 = 0;
                while (true) {
                    if (i3 >= boxSet.boxes.size()) {
                        break;
                    }
                    if (strArr[i2].equals(boxSet.boxes.get(i3).getClass().getSimpleName())) {
                        zArr[i2] = true;
                        break;
                    }
                    i3++;
                }
            } else {
                zArr[i2] = simpleName.equals(strArr[i2]);
            }
        }
        return zArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String[] getSelectedNames(String[] strArr, SparseBooleanArray sparseBooleanArray) {
        ArrayList arrayList = new ArrayList();
        int size = sparseBooleanArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (sparseBooleanArray.valueAt(i2)) {
                arrayList.add(strArr[sparseBooleanArray.keyAt(i2)]);
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    private String[] getSortedNames(InfoBox infoBox) {
        if (infoBox == null) {
            return this.boxClassNames;
        }
        int length = this.boxClassNames.length;
        String[] strArr = new String[length];
        String[] strArr2 = new String[length];
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5++) {
            String str = this.boxClassNames[i5];
            if (hasName(str, infoBox)) {
                strArr[i3] = str;
                i3++;
            } else {
                strArr2[i4] = str;
                i4++;
            }
        }
        while (i2 < i4) {
            strArr[i3] = strArr2[i2];
            i2++;
            i3++;
        }
        return strArr;
    }

    private String[] getTitles(String[] strArr) {
        int length = strArr.length;
        String[] strArr2 = new String[length];
        for (int i2 = 0; i2 < length; i2++) {
            String str = strArr[i2];
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                if (this.boxClassNames[i3].equals(str)) {
                    strArr2[i2] = App.m435a(this.boxTitles[i3]);
                    break;
                }
                i3++;
            }
        }
        return strArr2;
    }

    private boolean hasName(String str, InfoBox infoBox) {
        if (!(infoBox instanceof BoxSet)) {
            return str.equals(infoBox.getClass().getSimpleName());
        }
        BoxSet boxSet = (BoxSet) infoBox;
        for (int i2 = 0; i2 < boxSet.boxes.size(); i2++) {
            if (str.equals(boxSet.boxes.get(i2).getClass().getSimpleName())) {
                return true;
            }
        }
        return false;
    }

    public void addBox() {
        AlertDialog.Builder builder = new AlertDialog.Builder((Activity) this.view.getContext());
        final String[] sortedNames = getSortedNames(null);
        builder.setTitle(R.string.add_infobox).setItems(getTitles(sortedNames), new DialogInterface.OnClickListener() { // from class: display.vmap.VmpEditor.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                VmpEditor.this.changeBox(null, new String[]{sortedNames[i2]});
            }
        });
        builder.create().show();
    }

    public void editBox(final InfoBox infoBox) {
        AlertDialog.Builder builder = new AlertDialog.Builder((Activity) this.view.getContext());
        final String[] sortedNames = getSortedNames(infoBox);
        builder.setTitle(R.string.edit_infobox).setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() { // from class: display.vmap.VmpEditor.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                VmpEditor.this.changeBox(infoBox, VmpEditor.this.getSelectedNames(sortedNames, ((AlertDialog) dialogInterface).getListView().getCheckedItemPositions()));
            }
        }).setMultiChoiceItems(getTitles(sortedNames), getSelected(sortedNames, infoBox), new DialogInterface.OnMultiChoiceClickListener() { // from class: display.vmap.VmpEditor.2
            @Override // android.content.DialogInterface.OnMultiChoiceClickListener
            public void onClick(DialogInterface dialogInterface, int i2, boolean z) {
            }
        });
        builder.create().show();
    }

    public ArrayList<InfoBox> loadBoxes(String str) {
        ArrayList<InfoBox> arrayList = new ArrayList<>();
        String[] split = str.split(" ");
        int i2 = 0;
        while (i2 < split.length) {
            InfoBox createBox = createBox(split[i2]);
            if ((createBox instanceof BoxSet) && i2 < split.length - 1) {
                i2++;
                for (String str2 : split[i2].split("-")) {
                    InfoBox createBox2 = createBox(str2);
                    if (createBox2 != null) {
                        ((BoxSet) createBox).add(createBox2);
                    }
                }
            }
            if (createBox != null) {
                arrayList.add(createBox);
            }
            i2++;
        }
        return arrayList;
    }

    public void removeAllBoxes() {
        this.view.boxes.clear();
        C0099j.m527d("boxes", saveBoxes(this.view.boxes));
        this.view.initDisplay();
    }

    public String saveBoxes(ArrayList<InfoBox> arrayList) {
        StringBuilder sb = new StringBuilder();
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            InfoBox infoBox = arrayList.get(i2);
            sb.append(infoBox.getClass().getSimpleName() + " ");
            if (infoBox instanceof BoxSet) {
                BoxSet boxSet = (BoxSet) infoBox;
                int size2 = boxSet.boxes.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    sb.append(boxSet.boxes.get(i3).getClass().getSimpleName() + "-");
                }
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
