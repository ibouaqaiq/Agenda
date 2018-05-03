package com.example.issam.agenda;

import android.util.Log;

import com.example.issam.agenda.model.Persona;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import io.realm.DynamicRealm;
import io.realm.DynamicRealmObject;
import io.realm.FieldAttribute;
import io.realm.RealmMigration;
import io.realm.RealmObjectSchema;
import io.realm.RealmSchema;

public class Migration implements RealmMigration {

    @Override
    public void migrate(DynamicRealm realm, long oldVersion, long newVersion) {

        RealmSchema schema = realm.getSchema();
        if (oldVersion == 0) {
            Log.d("Migration", "actualitzant a la versió 1");
            RealmObjectSchema Schema = schema.get("Persona");
            Schema.addField("edad_tmp",int.class).transform(new RealmObjectSchema.Function() {
                @Override
                public void apply(DynamicRealmObject obj) {
                    String oldEdad = obj.getString("edad");
                    int edi = Integer.parseInt(oldEdad);
                    obj.setInt("edad_tmp",edi);
                }
            })
            .removeField("edad")
            .renameField("edad_tmp","edad");


            Schema.addField("nacimiento",int.class, FieldAttribute.INDEXED,FieldAttribute.REQUIRED)
            .transform(new RealmObjectSchema.Function() {
                @Override
                public void apply(DynamicRealmObject obj) {
                    Date date = new Date();
                    Calendar calendar = new GregorianCalendar();
                    calendar.setTime(date);
                    int year = calendar.get(Calendar.YEAR);
                    obj.set("nacimiento", year - obj.getInt("edad"));
                }
            });
            oldVersion++;

        }
    }
}
