import React, { lazy, Suspense } from 'react';

const LazyCourse = lazy(() => import('./Course'));

const Course = props => (
  <Suspense fallback={null}>
    <LazyCourse {...props} />
  </Suspense>
);

export default Course;
