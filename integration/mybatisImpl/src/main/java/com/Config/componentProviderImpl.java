package com.Config;//package com.Config;
//
//import java.io.IOException;
//import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.type.classreading.MetadataReader;
//import org.springframework.core.type.classreading.MetadataReaderFactory;
//import org.springframework.core.type.filter.TypeFilter;
//
///**
// * Created by hcj on 18-7-16
// */
//@Configuration
//public class componentProviderImpl extends ClassPathScanningCandidateComponentProvider {
//
//  public void addIncludeFilter(TypeFilter includeFilter) {
//    super.addIncludeFilter(new TypeFilter() {
//      @Override
//      public boolean match(MetadataReader metadataReader,
//          MetadataReaderFactory metadataReaderFactory)
//          throws IOException {
//        // 添加扫包的规则
//        String name = metadataReader.getClass().getName();
//        return !name.endsWith("");
//      }
//    });
//  }
//}
