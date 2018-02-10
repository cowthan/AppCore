/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014 daimajia
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package org.ayo.animate.yoyo.animator;

import android.animation.ObjectAnimator;

public class RotateOutUpLeftAnimator extends BaseViewAnimator {
    @Override
    public void prepare() {
        float x = mTarget.getPaddingLeft();
        float y = mTarget.getHeight() - mTarget.getPaddingBottom();
        mAnimatorSet.playTogether(
                ObjectAnimator.ofFloat(mTarget, "alpha", 1, 0),
                ObjectAnimator.ofFloat(mTarget, "rotation", 0, -90),
                ObjectAnimator.ofFloat(mTarget, "pivotX", x, x),
                ObjectAnimator.ofFloat(mTarget, "pivotY", y, y)
        );
    }
}
