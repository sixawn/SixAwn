/*
 * Copyright (c) 2019 by FITT.inc All rights reserved
 */
package com.fitt.sixawn.utils;

import org.dcm4che3.data.Attributes;
import org.dcm4che3.data.Tag;
import org.dcm4che3.io.DicomInputStream;

import java.io.File;
import java.io.IOException;
/**
 * <p>@description : DICOM文件解析工具类 </p>
 * <p>@author : <a href="mailto:congchun.zheng@gmail.com">Sixawn.ZHENG</a> </p>
 * <p>@since : 2019-09-27 </p>
 * <p>@version : 1.0.0 </p>
 */
public class DicomUtils {
    public static void getTagByFile(String pathFile) {
        try {
            File file = new File(pathFile);
            DicomInputStream dis = new DicomInputStream(file);
            Attributes fmi = dis.readFileMetaInformation();
            Attributes attrs = dis.readDataset(-1, -1);
            System.out.println("Series Instance UID:" + attrs.getString(Tag.SeriesInstanceUID));
            System.out.println("Study Instance UID:" + attrs.getString(Tag.StudyInstanceUID));
            System.out.println("Patient ID:" + attrs.getString(Tag.PatientID));
            System.out.println("Patient Name" + attrs.getString(Tag.PatientName));
            System.out.println("SOP Instance UID:" + attrs.getString(Tag.SOPInstanceUID));
            System.out.println(attrs.getString(Tag.ImageType));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
    }

    public static void main(String[] args) {

        String dicomFile = "/Users/sixawn/Workspace/Ewell/SourceCodes/dicom/0001_000001_1.3.46.670589.26.602471.25.20190829.152133.118593.0";
        getTagByFile(dicomFile);
    }
}
