/*
 *  This file is part of Waltz.
 *
 *     Waltz is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Waltz is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with Waltz.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.khartec.waltz.jobs;

import com.khartec.waltz.data.entity_statistic.EntityStatisticDao;
import com.khartec.waltz.model.EntityKind;
import com.khartec.waltz.model.ImmutableEntityReference;
import com.khartec.waltz.model.entity_statistic.EntityStatisticWithValue;
import com.khartec.waltz.service.DIConfiguration;
import org.jooq.DSLContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;


public class EntityStatisticHarness {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(DIConfiguration.class);
        DSLContext dsl = ctx.getBean(DSLContext.class);
        EntityStatisticDao dao = ctx.getBean(EntityStatisticDao.class);

        ImmutableEntityReference ref = ImmutableEntityReference.builder()
                .kind(EntityKind.APPLICATION)
                .id(1415)
                .build();

        List<EntityStatisticWithValue> values = dao.findStatisticsForEntity(ref, true);

        System.out.println(values.size());
//        ApplicationService applicationService = ctx.getBean(ApplicationService.class);
//        DSLContext dsl = ctx.getBean(DSLContext.class);
//
//        List<String> tagList = applicationService.findAllTags();
//
//        tagList.forEach(System.out::println);
//
//        System.out.println("---------------");
//
//        applicationService.findByTag("not-good-at-flying").forEach(a -> System.out.println(a.name()));
//
//        System.out.println(applicationService.findTagsForApplication(521L));
//

    }



}