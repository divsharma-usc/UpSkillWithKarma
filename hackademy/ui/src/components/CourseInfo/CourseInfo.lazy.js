import React, { lazy, Suspense } from 'react';

const LazyCourseInfo = lazy(() => import('./CourseInfo'));

const CourseInfo = props => (
  <Suspense fallback={null}>
    <LazyCourseInfo {...props} />
  </Suspense>
);

export default CourseInfo;
